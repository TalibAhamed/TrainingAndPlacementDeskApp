/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import trandpl.dbutil.DBConnection;
import trandpl.pojo.QuestionPojo;

/**
 *
 * @author 91748
 */
public class QuestionDAO {
    public static boolean setPaper(List<QuestionPojo> questionList)throws SQLException{
        Connection conn=DBConnection.getConnection();
        int count=0;
        PreparedStatement ps=conn.prepareStatement("Insert into questions values(?,?,?,?,?,?,?,?");
        for(QuestionPojo question:questionList){
            ps.setString(1, question.getJobId());
            ps.setInt(2, question.getQno());
            ps.setString(3, question.getQuestion());
            ps.setString(4, question.getOption1());
            ps.setString(5,question.getOption2());
            ps.setString(6, question.getOption3());
            ps.setString(7, question.getOption4());
            ps.setInt(8, question.getCorrectOption());
            int res=ps.executeUpdate();            
            if(res==1)
                ++count;
        }
        if(count==questionList.size())
            return true;
        return false;
    }
}
