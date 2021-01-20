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
import java.sql.PreparedStatement;
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
import javafx.scene.control.TableColumn.CellEditEvent;
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
public class AllStudentsController implements Initializable {

    @FXML private TableView <Student> TableView;
    @FXML private TableColumn <Student, String> firstNameC;
    @FXML private TableColumn <Student, String> lastNameC;
    @FXML private TableColumn <Student, String> IdC;
    @FXML private TableColumn <Student, String> GroupName;
    @FXML
    private TextField firstNameA;
    @FXML
    private TextField secondNameA;
    @FXML
    private TextField StudentNrA;
    @FXML
    private TextField GroupNameA;
    @FXML
    private Button editButton;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void changeFirstNameCellEvent(CellEditEvent editedCell)
    {
        Student studentSelected = TableView.getSelectionModel().getSelectedItem();
        studentSelected.setFirstname(editedCell.getNewValue().toString());
    }
    public void changelastNameCellEvent(CellEditEvent editedCell)
    {
        Student studentSelected = TableView.getSelectionModel().getSelectedItem();
        studentSelected.setFirstname(editedCell.getNewValue().toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    editButton.setDisable(true);
    firstNameC.setCellValueFactory(new PropertyValueFactory <Student,String> ("firstname"));
    lastNameC.setCellValueFactory(new PropertyValueFactory <Student,String> ("lastname"));
    IdC.setCellValueFactory(new PropertyValueFactory <Student ,String> ("studentId"));
    GroupName.setCellValueFactory(new PropertyValueFactory <Student ,String> ("groupName"));
        try {
            TableView.setItems(getPeople());
        } catch (SQLException ex) {
            Logger.getLogger(AllStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    TableView.setEditable(true);
    firstNameC.setCellFactory(TextFieldTableCell.forTableColumn());
    lastNameC.setCellFactory(TextFieldTableCell.forTableColumn());
    
        // TODO
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
    @FXML
        public void add(ActionEvent event) throws SQLException
        {
            Student newStudent = new Student(firstNameA.getText(), secondNameA.getText(), StudentNrA.getText(), GroupNameA.getText(),-1);
            TableView.getItems().add(newStudent);
            newStudent.doingStuff();
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

          String sql = "select * FROM Students";
          
          stat = conn.prepareStatement(sql);
          
          resSet = stat.executeQuery(sql);
//           Date db = Date.valueOf()
    while (resSet.next())
    {
     
        Student student = new Student (resSet.getString("StudentName"),resSet.getString("StudentLast"), resSet.getString("StudentId"), resSet.getString("StudentGrp"),resSet.getInt("ID") );
    
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
@FXML
public void onEdit(ActionEvent event) throws IOException
{
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("Edit.fxml"));
Parent EditScene = loader.load();
Scene visiStudentaiScene = new Scene(EditScene);
Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
window.setScene(visiStudentaiScene);
window.show();
 
EditController cntr = loader.getController();
cntr.initData(TableView.getSelectionModel().getSelectedItem());

}
public void select()
{
    editButton.setDisable(false);
}
}