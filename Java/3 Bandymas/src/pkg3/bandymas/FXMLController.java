/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.bandymas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField Pinigai;
    @FXML
    private TextField Metai;
    @FXML
    private TextField menesiai;
    @FXML
    private CheckBox isLinear; // kolkas nenaudojami
    @FXML
    private CheckBox isNotLinear; // kolkas nenaudojami 
    @FXML
    private TextField interest;
    @FXML private TableView<DataForMe> tableView;
    @FXML
    private TableColumn<DataForMe, Integer> month;
    @FXML
    private TableColumn <DataForMe, Double> total; // arba cia kazkas 
    @FXML
    private TableColumn<DataForMe, Double> NonPalukanos;
    @FXML
    private TableColumn<DataForMe, Double> Palukanos;

   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        double bakes = Double.parseDouble(Pinigai.getText());
        int asNusizudysiu = Integer.parseInt(Metai.getText());
        int LabaiGreitai = Integer.parseInt(menesiai.getText());
        double jeiguSiProgramaNeveiks = Double.parseDouble(interest.getText()) ;
        
        
                 if ( isLinear.isSelected()) 
    {
        linear Loan = new linear(bakes, asNusizudysiu, LabaiGreitai  , jeiguSiProgramaNeveiks );
        Loan.Calculator();
        ObservableList<DataForMe> dates = FXCollections.observableArrayList();
         for (int i = 0 ; i < Loan.monthcount; i ++)
        {
           dates.add(new DataForMe(Loan,i));
        }
      month.setCellValueFactory(new PropertyValueFactory <> ("month"));      
     total.setCellValueFactory(new PropertyValueFactory <> ("monthlyPayment" )); // cia kazkas negerai.... 
       NonPalukanos.setCellValueFactory(new PropertyValueFactory <> ("interest" ));
        Palukanos.setCellValueFactory(new PropertyValueFactory <> ("amountLeft"));  
       tableView.setItems(dates);
       tableView.getColumns().setAll(month, total,NonPalukanos,Palukanos);
    }
         else if ( isNotLinear.isSelected())
                 {
        Anuino Loan = new Anuino(bakes, asNusizudysiu, LabaiGreitai  , jeiguSiProgramaNeveiks );
        Loan.Calculator();
        ObservableList<DataForMe> dates = FXCollections.observableArrayList();
         for (int i = 0 ; i < Loan.monthcount; i ++)
        {
           dates.add(new DataForMe(Loan,i));
        }
      month.setCellValueFactory(new PropertyValueFactory <> ("month"));      
     total.setCellValueFactory(new PropertyValueFactory <> ("monthlyPayment" )); // cia kazkas negerai.... 
       NonPalukanos.setCellValueFactory(new PropertyValueFactory <> ("interest" ));
        Palukanos.setCellValueFactory(new PropertyValueFactory <> ("amountLeft"));  
       tableView.setItems(dates);
       tableView.getColumns().setAll(month, total,NonPalukanos,Palukanos);
                 }
                 
    }
    

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
