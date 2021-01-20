/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;

     @FXML
   private TableView<information> tableView;
      @FXML
   private TableColumn<information,double[]> monthCol;
       @FXML
    private TableColumn <information,double[]> sumCol;
        @FXML
    private TableColumn<information,double[]> nahuicol;
         @FXML
    private TableColumn<information, double[]> procCol;
    

    
    @FXML
    private TextField money;
    @FXML
    private TextField years;
    @FXML
    private TextField months;
    @FXML
    private TextField interest;
        @FXML
    private CheckBox linijinis;
    @FXML
    private CheckBox taskitas;
    
    double pinigai;
    double metai;
    double menesiai;
    boolean Palukanos;
    double kof;
    boolean isLinear = true;
    boolean butPressed = false;
    String Informacija = "";

    public void sceneSwitch(ActionEvent event) throws IOException {
        
        Parent tableParent = FXMLLoader.load(getClass().getResource("table.fxml")); // neveikia nes istryniau viska
        Scene table = new Scene(tableParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(table);
        window.show();
        
        
    }
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    pinigai = Double.parseDouble(money.getText());
    metai = Double.parseDouble(years.getText());
    menesiai = Double.parseDouble(months.getText());
    kof = Double.parseDouble(interest.getText());
    butPressed = true;
    whichIsMethod();
        System.out.println(pinigai+ "  " + metai + "  " + menesiai + "  " + kof + "  " + isLinear );
        Calculator Paskola = new Calculator(pinigai, metai, menesiai, kof, isLinear);
        
        ObservableList<information> date = FXCollections.observableArrayList();
        
        
        for (int i = 0 ; i < Paskola.getYears()*12 + Paskola.getMonths(); i ++)
        {
            date.add(new information (Paskola ,i));
        }
        monthCol.setCellValueFactory(new PropertyValueFactory <> ("1" ));
        sumCol.setCellValueFactory(new PropertyValueFactory <> ("2" ));
        nahuicol.setCellValueFactory(new PropertyValueFactory <> ("3" ));
        procCol.setCellValueFactory(new PropertyValueFactory <> ("4" ));
        tableView.setItems(date);
        tableView.getColumns().setAll(monthCol, sumCol,nahuicol,procCol );
        
        
        
        
        
        
        
      //  Informacija += Calculator.returnText();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        if (butPressed){
//        XYChart.Series series = new XYChart.Series();
//        series.getData().add(new XYChart.Data("1", pinigai/(metai*12)+menesiai));
//        series.getData().add(new XYChart.Data("2", pinigai/(metai*12)+menesiai));
//        series.getData().add(new XYChart.Data("3", pinigai/(metai*12)+menesiai));
//        series.getData().add(new XYChart.Data("4", pinigai/(metai*12)+menesiai));
//        series.getData().add(new XYChart.Data("5", pinigai/(metai*12)+menesiai));
//        series.getData().add(new XYChart.Data("6", pinigai/(metai*12)+menesiai));
//        LineChart.getData().addAll(series);
        }
    
public void whichIsMethod()
{
    if(linijinis.isSelected())
    {
        this.isLinear = true;
    }
    else if (taskitas.isSelected())
    {
        this.isLinear = false;
    }
}
}
    

