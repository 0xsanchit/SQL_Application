package com.g1;


import java.sql.*;
import java.util.*;


public class Query1 {
    /* updateCourse(s, DepartmentID, CourseID, TeacherId, ClassRoom) */
    public static String updateCourse(SQLConnection s,String deptId,String cId, String tId, String cRoom) throws SQLException{
        /* dept Id validation */
        String deptIdsQuery = "SELECT deptId FROM department";
        ResultSet deptIdsResultSet = s.executeQuery(deptIdsQuery);
        Set<String>deptIdsList = new HashSet<String>();
        while(deptIdsResultSet.next()){
            deptIdsList.add(deptIdsResultSet.getString("deptId"));
        }
        if(!deptIdsList.contains(deptId)){
            return "Update Failed, Department Id="+deptId+" does not exist!";
        }

        /* courseId validation, if cId is not already in courses List, update fails */
        String courseIdsQueryString = "SELECT courseId FROM course WHERE deptNo="+deptId;
        ResultSet courses = s.executeQuery(courseIdsQueryString);
        Set<String>coursesList = new HashSet<String>();
        while(courses.next()){
            coursesList.add(courses.getString("courseId"));
        }
        if(!coursesList.contains(cId)){
            return "Update Failed, Course Id="+cId+" not offered in the department!";
        }

        /* teacher ID validation */
        String teacherQuery = "SELECT empId FROM professor WHERE deptNo="+deptId;
        ResultSet profsResult = s.executeQuery(teacherQuery);
        Set<String>profsList = new HashSet<String>();
        while(profsResult.next()){
            profsList.add(profsResult.getString("empId"));
        }
        if(!profsList.contains(tId)){
            return "Update Failed, Teacher Id="+tId+" not in the department!";
        }
        
        /* updating course, if tuple already exists with given course number, update teacher ID and Room number otherwise Insert a new tuple */
        String teachingQuery = "SELECT empId, courseId from teaching WHERE sem = 'Even' AND year = 2006";
        ResultSet reqTeaching = s.executeQuery(teachingQuery);
        boolean updated = false;
        while(reqTeaching.next()){
            String courseId = reqTeaching.getString("courseId");
            if(courseId.equals(cId)){
                String updateQuery = "UPDATE teaching SET empId = '"+tId+"', classRoom = '"+cRoom+"' WHERE courseId = '"+cId+"' AND sem = 'Even' AND year = 2006";
                s.executeUpdate(updateQuery);
                updated = true;
                break;
            }
        }
        if(!updated){
            String insertQuery = "INSERT INTO teaching VALUES ('"+tId+"','"+cId+"','Even',2006,'"+cRoom+"');";
            s.executeUpdate(insertQuery);
            return "Inserted course successfully.";
        }
        else{
            return "Updated course successfully.";
        }



    }
    
}
