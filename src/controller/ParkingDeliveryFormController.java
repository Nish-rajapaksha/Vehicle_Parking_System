package controller;

import db.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DeliveryVehicle;
import model.ParkVehicle;

import java.io.IOException;

public class ParkingDeliveryFormController {
    public ComboBox cmbSelectParkingDelivery;
    public AnchorPane ParkingDeliveryContext;
    public TableView tblParkingDelivery;
    public TableColumn colParkedTime;
    public TableColumn colParkingSlot;
    public TableColumn colVehicleType;
    public TableColumn colVehicleNumber;

    public void initialize(){

        cmbSelectParkingDelivery.getItems().add("In Parking");
        cmbSelectParkingDelivery.getItems().add("On Delivery");
        inParkingDataLoad();









    }


    public void AddVehicleOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage =(Stage) ParkingDeliveryContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddVehicleForm.fxml"))));
        stage.setTitle("Add Vehicle Form");

        
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) ParkingDeliveryContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/MainForm.fxml"))));


    }

    public void AddDriverOnAction(ActionEvent actionEvent) throws IOException {


        Stage stage =(Stage) ParkingDeliveryContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddDriverForm.fxml"))));
        stage.setTitle("Add Driver Form");


    }


    public void inParkingOnAction(ActionEvent actionEvent) {
        if(cmbSelectParkingDelivery.getValue().equals("In Parking")){
            colParkingSlot.setText("Parking Slot");
            colParkedTime.setText("Parked Time");
           inParkingDataLoad();


        }
        if(cmbSelectParkingDelivery.getValue().equals("On Delivery")){

            colParkingSlot.setText("Driver Name");
            colParkedTime.setText("Left Time");

            inDeliveryDataLoad();

        }



    }

    private void inParkingDataLoad() {
        ObservableList<ParkVehicle>  obList= FXCollections.observableArrayList();

            for (ParkVehicle p: DataBase.vehiclePark){
                ParkVehicle tm=new ParkVehicle(p.getVehicleNumber(),p.getVehicleType(),p.getParkingSlot(),p.getParkTime());
                obList.add(tm);
            }
            tblParkingDelivery.setItems(obList);


        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("parkTime"));



    }

   private void inDeliveryDataLoad(){


        ObservableList<DeliveryVehicle>  obList= FXCollections.observableArrayList();

        for (DeliveryVehicle d: DataBase.vehicleDelivery){
            DeliveryVehicle d1 =new DeliveryVehicle(d.getVehicleNumber(),d.getVehicleType(),d.getDriverName(),d.getLeftTime());
            obList.add(d1);
        }
        tblParkingDelivery.setItems(obList);



       colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
       colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
       colParkingSlot.setCellValueFactory(new PropertyValueFactory("driverName"));
       colParkedTime.setCellValueFactory(new PropertyValueFactory("leftTime"));






    }

}
