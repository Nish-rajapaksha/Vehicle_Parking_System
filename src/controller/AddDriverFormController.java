package controller;

import db.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.io.IOException;


public class AddDriverFormController {
    public AnchorPane AddDriverContext;
    public TextField txtContactNumber;
    public TextField txtAddress;
    public TextField txtDlN;
    public TextField txtNic;
    public TextField txtDriverName;

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) AddDriverContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ParkingDeliveryForm.fxml"))));
    }

    public void btnAddDriver(ActionEvent actionEvent) {

     /*   if (txtDriverName.getText().matches("[A-Z]{1}[a-z][ ][A-Z]{1}[a-z]") && txtNic.getText().matches("[0-9]{12}[V]") && txtDlN.getText().matches("[B][0-9]{7}") && txtAddress.getText().matches("[A-Z]{1}[a-z]*") && txtContactNumber.getText().matches("[0-9]{3}[-][0-9]{7}")) {


            Driver d1 = new Driver(txtDriverName.getText(), txtNic.getText(), txtDlN.getText(), txtAddress.getText(), txtContactNumber.getText());
            DataBase.driverArrayList.add(d1);

            new Alert(Alert.AlertType.CONFIRMATION, "Driver Added Successful!").show();

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING, "DATA NOT VALID");
            alert.show();
        } */
      if (DataBase.driverArrayList.size() < 20){
          Driver d1 = new Driver(txtDriverName.getText(), txtNic.getText(), txtDlN.getText(), txtAddress.getText(), txtContactNumber.getText());
          DataBase.driverArrayList.add(d1);
          new Alert(Alert.AlertType.CONFIRMATION, "Driver Added Successful!").show();
      }else
      {
          Alert alert = new Alert(Alert.AlertType.WARNING, "Maximum drivers are added to the system");
          alert.show();

      }

    }
}


