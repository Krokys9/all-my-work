/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manodarbas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     public void AllStudentsScene(ActionEvent event) throws IOException
    {
        Parent AllStudentsParent = FXMLLoader.load(getClass().getResource("AllStudents.fxml"));
        Scene AllStudentsScene = new Scene(AllStudentsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(AllStudentsScene);
        window.show();
    
    }
    @FXML
        public void AllGroupsScene(ActionEvent event) throws IOException
    {
        Parent AllGroupsParent = FXMLLoader.load(getClass().getResource("AllGroups.fxml"));
        Scene AllGroupsScene= new Scene(AllGroupsParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(AllGroupsScene);
        window.show();
    
    }
    @FXML
            public void activyScene(ActionEvent event) throws IOException
    {
        Parent AddStudentParent = FXMLLoader.load(getClass().getResource("ShowGroupActivity.fxml"));
        Scene AddStudentScene = new Scene(AddStudentParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(AddStudentScene);
        window.show();
    
    }
    @FXML
                public void EditScene(ActionEvent event) throws IOException
    {
        Parent EditParent = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        Scene EditScene = new Scene(EditParent );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(EditScene);
        window.show();
    
    }
    
}

