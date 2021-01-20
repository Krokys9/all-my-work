/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manodarbas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AllGroupsController implements Initializable {
    @FXML
    private TableColumn<Group, Integer> IdC;
    @FXML
    private TableColumn<Group, String> GroupNameC;

    @FXML
    private TableView<Group> tableView;
    @FXML
    private TextField GroupNameT;
    @FXML
    private Button EditButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    EditButton.setDisable(true);
    GroupNameC.setCellValueFactory(new PropertyValueFactory <Group,String> ("groupName"));
    IdC.setCellValueFactory(new PropertyValueFactory <Group ,Integer> ("id"));
        try {
            tableView.setItems(getPeople());
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AllGroupsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void clicked ()
    {
        EditButton.setDisable(false);
    }
    @FXML
        public void Back(ActionEvent event) throws IOException
    {
        Parent visiStudentaiParent = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene visiStudentaiScene = new Scene(visiStudentaiParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(visiStudentaiScene);
        window.show();
}
//        public void add(ActionEvent event)
//        {
//            Student newStudent = new Student(firstNameA.getText(), secondNameA.getText(), DateA.getValue());
//            TableView.getItems().add(newStudent);
//        }
            @FXML
        public void add(ActionEvent event) throws SQLException
        {
            Group group = new Group(GroupNameT.getText(),-1);
            tableView.getItems().add(group);
            group.doingStuff();
        }
               public ObservableList<Group> getPeople() throws SQLException
        {
            ObservableList<Group> people = FXCollections.observableArrayList();
            
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

          String sql = "select * FROM sGroup";
          
          stat = conn.prepareStatement(sql);
          
          resSet = stat.executeQuery(sql);
//           Date db = Date.valueOf()
    while (resSet.next())
    {
     
        Group student = new Group(resSet.getString("GroupName"),resSet.getInt("ID") );
    
    people.add(student);
    
    }
    tableView.getItems().addAll(people);
             
             
             
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

@FXML
public void onEdit(ActionEvent event) throws IOException
{
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("EditGroup.fxml"));
Parent EditScene = loader.load();
Scene visiStudentaiScene = new Scene(EditScene);
EditGroupController cntr = loader.getController();
cntr.initData(tableView.getSelectionModel().getSelectedItem());
Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
window.setScene(visiStudentaiScene);
window.show();
 


}
}