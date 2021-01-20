/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manodarbas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditGroupController implements Initializable {

       
    Group sStudent;
    @FXML
    private TextField GroupName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            public void initData(Group student)
        {
            this.sStudent = student;
            GroupName.setText(sStudent.getGroupName());
            
        }
                   public void EditData() throws SQLException
       {
           sStudent.setGroupName(GroupName.getText()); 
            sStudent.editData();
       }
}