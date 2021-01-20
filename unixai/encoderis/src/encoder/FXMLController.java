/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField Key;
    @FXML
    private TextField FileName;
    @FXML
    private Button Btn;
    public int K;
    public String Filename;
           

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
        
    }    
    @FXML
    private void Read()
    {
        GlobalClass.Key = Integer.parseInt(Key.getText().toString());
        GlobalClass.filename = FileName.getText().toString();
    }
    
}
