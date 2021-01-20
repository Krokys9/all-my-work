/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manodarbas;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */

public class ShowGroupActivityController implements Initializable {
    
    Student student;
    @FXML
    private TableView<Student> TableView;
    @FXML
    private TableColumn<Student, String> GroupC;
    @FXML
    private TableColumn<Student, String> dateC;
    @FXML
    private TextField Name;
    @FXML
    private TextField Date;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    GroupC.setCellValueFactory(new PropertyValueFactory <Student,String> ("firstname"));
    dateC.setCellValueFactory(new PropertyValueFactory <Student,String> ("lastname"));
            try {
            TableView.setItems(getPeople());
        } catch (SQLException ex) {
            Logger.getLogger(AllStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void addData() throws SQLException
    {
        Student newStudent = new Student(Name.getText(), Date.getText(), "null", "null",-1);
         TableView.getItems().add(newStudent);
        Connection conn = null;
        PreparedStatement stat = null;
        try 
        {
                      
         conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/namudarbas", "namudarbas", "asd123asd123");
//          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/namudarbas", "root", "root");
            
        String sql = "Insert INTO activity(GroupName, activityDay)" + "values (?,?)";
        stat = conn.prepareStatement(sql);
        stat.setString(1, Name.getText());
        stat.setString(2,Date.getText());
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
      public ObservableList<Student> getPeople() throws SQLException
        {
            ObservableList<Student> people = FXCollections.observableArrayList();
            
                Connection conn = null;
                Statement stat = null;
                ResultSet resSet = null;
            try
            {
                    
         conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/namudarbas", "namudarbas", "asd123asd123");
//          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/namudarbas", "root", "root");
            
            
          if (conn != null)
              
           {
                System.out.println("Luka dabar miega");
           }

          String sql = "select * FROM activity";
          
          stat = conn.prepareStatement(sql);
          
          resSet = stat.executeQuery(sql);
//           Date db = Date.valueOf()
    while (resSet.next())
    {
     
        Student student = new Student (resSet.getString("GroupName"),resSet.getString("activityDay"), "null", "null" ,resSet.getInt("ID") );
    
    people.add(student);
    
    }
    TableView.getItems().addAll(people);
             
             
             
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

            return people;
        }
}

