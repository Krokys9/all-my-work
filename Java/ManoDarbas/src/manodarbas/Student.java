/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manodarbas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author User
 */
public class Student {
    private SimpleStringProperty firstname, lastname, studentId, groupName;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
    public Student (String firstname, String lastname,String  studentId, String groupName , int id) throws SQLException
    {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.studentId = new SimpleStringProperty(studentId);
        this.groupName = new SimpleStringProperty(groupName);
        this.id = id;
      
    }

    public void setFirstname(String firstname) {
        this.firstname = new SimpleStringProperty(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname = new SimpleStringProperty(lastname);
    }
        public void setgroupName(String groupName) {
        this.groupName = new SimpleStringProperty(groupName);
    }
            public void setstudentId(String studentId) {
        this.studentId = new SimpleStringProperty(studentId);
    }


    public String getFirstname() {
        return firstname.get();
    }

    public String getLastname() {
        return lastname.get();
    }
    
    public String getGroupName() {
        return groupName.get();
    }
        public String getStudentId() {
        return studentId.get();
    }

    public void doingStuff() throws SQLException
{
    Connection conn = null;
    PreparedStatement stat = null;
            try
            {
                    
         conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/namudarbas", "namudarbas", "asd123asd123");
//          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/namudarbas", "root", "root");
            
            
          if (conn != null)
              
           {
                System.out.println("Luka dabar miega");
           }

          String sql = "INSERT INTO Students(StudentName,StudentLast,StudentID,StudentGrp)" + "VALUES (?,?,?,?)";
          
          stat = conn.prepareStatement(sql);
          
//           Date db = Date.valueOf()

          stat.setString(1,this.getFirstname());
          stat.setString(2,this.getLastname());
          stat.setString(3, this.getStudentId());
          stat.setString(4,this.getGroupName());
          
          stat.executeUpdate();
             
             
             
            }
            catch(SQLException e)
            {
                     System.err.println(e.getMessage());
                     System.err.println("failed to connect");
            }
            finally
            {
                if(stat!= null)
                {
                    stat.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
}
        public void editData() throws SQLException
{
    Connection conn = null;
    PreparedStatement stat = null;
            try
            {
                    
         conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/namudarbas", "namudarbas", "asd123asd123");
//          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/namudarbas", "root", "root");
            
            
          if (conn != null)
              
           {
                System.out.println("Luka dabar miega");
           }

          String sql = "UPDATE  Students SET StudentName = ? , StudentLast = ?, StudentID=? , StudentGrp=?"+ "WHERE ID = ?";
          
          stat = conn.prepareStatement(sql);
          
//           Date db = Date.valueOf()

          stat.setString(1,this.getFirstname());
          stat.setString(2,this.getLastname());
          stat.setString(3, this.getStudentId());
          stat.setString(4,this.getGroupName());
          stat.setInt(5, this.id);
          
          stat.executeUpdate();
             
             
             
            }
            catch(SQLException e)
            {
                     System.err.println(e.getMessage());
                     System.err.println("failed to connect");
            }
            finally
            {
                if(stat!= null)
                {
                    stat.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            }
}
}
