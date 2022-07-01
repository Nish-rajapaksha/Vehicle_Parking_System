package controller;

import db.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ParkVehicle;
import model.Vehicle;

import java.io.IOException;
import java.util.Optional;

public class AddVehicleFormController {
    public AnchorPane AddVehicleContext;
    public ComboBox cmbVehicleType;
    public TextField txtVehicleNmbr;
    public TextField txtMaximumW;
    public TextField txtNoPassengers;

    public void HomeOnAction(ActionEvent actionEvent) throws IOException {



        Stage stage =(Stage)AddVehicleContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ParkingDeliveryForm.fxml"))));
    }

    public void btnAddVehicle(ActionEvent actionEvent) {

        if (DataBase.vehicleArrayList.size() < 16) {

            Vehicle v1 = new Vehicle(txtVehicleNmbr.getText(), (String) cmbVehicleType.getValue(), txtMaximumW.getText(), Integer.parseInt(txtNoPassengers.getText()));
            DataBase.vehicleArrayList.add(v1);
            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added Successful!").show();



            } else {

            new Alert(Alert.AlertType.WARNING, "Maximum vehicles are added to the System !").show();



            }


    }


    public void initialize () {

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Van");
        obList.add("Bus");
        obList.add("Cargo Lorry");
        cmbVehicleType.setItems(obList);

    }
}
