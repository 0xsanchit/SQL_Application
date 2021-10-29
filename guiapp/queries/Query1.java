import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class Query1 {
    public static String updateCourse(SQLConnection s,String deptId,String cId, String tId, String cRoom){

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

        /* courseId validation, if a course is not already in courses List, update fails */
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
            return "Update Failed, Teacher Id="+tId+" is unrecognized!";
        }
        
        /* updating course, if tuple already exists with given course number, update teacher ID and Room number otherwise Insert a new tuple */
        String teachingQuery = "SELECT empId, courseId from teaching WHERE sem = 'Even' AND year = 2006";
        Statement stmt = s.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // ResultSet is set as updatable
        ResultSet reqTeaching = stmt.executeQuery(teachingQuery);
        Set<String>teachingList = new HashSet<String>();
        boolean updated = false;
        while(reqTeaching.next()){
            String courseId = reqTeaching.getString("courseId");
            if(courseId==cId){
                reqTeaching.updateString("empId", tId);
                reqTeaching.updateString("classRoom", cRoom);
                updated = true;
                break;
            }
        }
        if(!updated){
            reqTeaching.moveToInsertRow();
            reqTeaching.updateString("empId", tId);
            reqTeaching.updateString("courseId", cId);
            reqTeaching.updateString("sem", "Even");
            reqTeaching.updateFloat("year", 2006);
            reqTeaching.updateString("classRoom", cRoom);
            reqTeaching.insertRow();
            reqTeaching.beforeFirst();
            return "Inserted course successfully.";
        }
        else{
            return "Updated course successfully.";
        }



    }
    
}
