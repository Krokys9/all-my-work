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
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author User
 */
public class Group {
    private SimpleStringProperty groupName;
       private int id=-1;

    public String getGroupName() {
        return groupName.get();
    }


    public void setGroupName(String groupName) {
        this.groupName = new SimpleStringProperty(groupName);
    }
    
    
        Group(String groupName, int id)
        {
            this.groupName = new SimpleStringProperty(groupName);
            this.id = id;
        }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

          String sql = "INSERT INTO sGroup(GroupName)" + "VALUES (?)";
          
          stat = conn.prepareStatement(sql);
          
//           Date db = Date.valueOf()


          stat.setString(1,this.getGroupName());
          
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

          String sql = "UPDATE  sGroup SET GroupName = ? "+ "WHERE ID = ?";
          
          stat = conn.prepareStatement(sql);
          
//           Date db = Date.valueOf()

          stat.setString(1,this.getGroupName());
          stat.setInt(2, this.id);
          
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
