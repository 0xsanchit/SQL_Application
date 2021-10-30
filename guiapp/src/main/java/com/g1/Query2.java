package com.g1;

import java.sql.*;
import java.util.*;

public class Query2{

    private static void recurse(HashSet<ArrayList<String>> p, String cid, HashSet<String> allpre)
    {
        String key,value;
        for(ArrayList<String> itr : p)
        {
            key = itr.get(0);
            value = itr.get(1);
            if(value.equals(cid) && !allpre.contains(key))
            {
                recurse(p, key, allpre);
                allpre.add(key);
            }
        }
    }
    private static boolean checkEligibility(HashSet<ArrayList<String>> p, String cid, HashSet<String> pset)
    {
        HashSet<String> allpreReq = new HashSet<String>();
        recurse(p,cid,allpreReq);
        for(String  itr : allpreReq)
        {
            if(!pset.contains(itr))
            {
                return false;
            }
        }
        return true;
    }
    public static String makeEnrollment(SQLConnection s,String rno,String cid) throws SQLException
    {
        String slistQuery = "SELECT rollNo FROM student";
        ResultSet studentList = s.executeQuery(slistQuery);
        HashSet<String> slist = new HashSet<String>();
        while(studentList.next())
        {
            slist.add(studentList.getString("rollNo"));
        }
        if(!slist.contains(rno))
        {
            return "Unknown Student! Enrollment failed";
        }

        String clistQuery = "SELECT courseId FROM course";
        ResultSet courseList = s.executeQuery(clistQuery);
        HashSet<String> clist = new HashSet<String>();
        while(courseList.next())
        {
            clist.add(courseList.getString("courseId"));
        }
        if(!clist.contains(cid))
        {
            return "Unknown Course! Enrollment failed";
        }

        String passlistQuery = "SELECT courseId FROM enrollment WHERE grade != 'U' AND grade != 'P' AND year < 2006 AND rollNo = " + rno;
        // NO MORE RESTRICTIONS IN THE ABOVE QUERY AS 2006 EVEN SEM >= ALL ENROLLMENTS
        ResultSet passList = s.executeQuery(passlistQuery);
        HashSet<String> passSet = new HashSet<String>();
        while(passList.next())
        {
            passSet.add(passList.getString("courseId"));
        }

        String preReqQuery = "SELECT preReqCourse AS p, courseId AS c FROM prerequisite";
        ResultSet prereqRS = s.executeQuery(preReqQuery);
        HashSet<ArrayList<String>> preRequisites = new HashSet<ArrayList<String>>();
        HashSet<String>  probableCourses = new HashSet<String>();
        String k,v;
        while(prereqRS.next())
        {
            k = prereqRS.getString("p");
            v = prereqRS.getString("c");
            probableCourses.add(k);
            probableCourses.add(v);
            ArrayList<String> a = new ArrayList<>();
            a.add(k);
            a.add(v);
            preRequisites.add(a);
        }

        if(probableCourses.contains(cid) && !checkEligibility(preRequisites,cid,passSet))
        {
           return "The student has not successfully completed all the required prerequisites! Enrollment failed";
        }
        else
        {
            //P for pending grade
            String insertQuery = "INSERT INTO enrollment VALUES(\'"+rno+"\',\'"+cid+"\',\'even\',\'2006\',\'P\')";
            int res = s.executeUpdate(insertQuery);
            if(res <= 0) {
                return "Insert Query Error!";
            }
            return "The student has been successfully enrolled for the course";
        }
    }
}