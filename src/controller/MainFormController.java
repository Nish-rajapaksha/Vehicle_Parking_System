package controller;

import db.DataBase;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import model.DeliveryVehicle;
import model.Driver;
import model.ParkVehicle;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class MainFormController {
    public AnchorPane MainContext;
    public Label lblTime;
    public TextField lblSlotNumber;
    public ComboBox cmbDriver;
    public TextField txtVehicleType;
    public ComboBox cmbSelectVehicle;
    public Label lblVehicleType;
    public Label lblSlotNumber1;
    public Label lblDate;

    String clickValue;



    public void ManagerLoginOnAction(ActionEvent actionEvent) throws IOException {

     setUI("LoginForm");


    }

    private void setUI(String location) throws IOException {

        Stage stage = (Stage) MainContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/" + location + ".fxml"))));
        stage.setTitle("Login Form");

    }

    private void LocalTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
           lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        

    }

     public void LocalDate() throws InterruptedException {
        SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblDate.setText(DateFormatter.format(date));
        Thread.sleep(1000);
    }

    private boolean checkselectdrive() {
        boolean b= false;
        if (cmbDriver.getValue()==null){
            b=true;
        }

        return  b;
    }
    private boolean checkdelevereddriver() {
        boolean b= false;
        for (int i=0; i<DataBase.vehicleDelivery.size();i++){
            if (cmbDriver.getValue().equals(DataBase.vehicleDelivery.get(i).getDriverName())){
                b=true;
            }
        }
        return b;
    }



    public void btnDeliveryOnAction(ActionEvent actionEvent) {
        if (checkselectdrive()){
            Alert alert=new Alert(Alert.AlertType.ERROR,"NOT SELECTED DRIVER",
                    ButtonType.OK);
            alert.show();
        }else {    if (checkdelevereddriver()){
            Alert alert=new Alert(Alert.AlertType.WARNING,"SELECTED DRIVER ALREADY DELIVERED VEHICLE",
                    ButtonType.OK);
            alert.show();
        }else {
            for(int i = 0;i<DataBase.vehiclePark.size();i++){

                if(clickValue.equals(DataBase.vehiclePark.get(i).getVehicleNumber())){
                    DataBase.vehiclePark.remove(i);
                }


            }


            DeliveryVehicle d1 = new DeliveryVehicle((String) cmbSelectVehicle.getValue(), lblVehicleType.getText(), (String) cmbDriver.getValue(), lblTime.getText());
            DataBase.vehicleDelivery.add(d1);

            for(int j =0;j<DataBase.slotTable.size();j++){

                if(lblSlotNumber1.getText().equals(DataBase.slotTable.get(j).getSlotNumber())){
                    DataBase.slotTable.get(j).setSlotStatus("notused");

                }
            }


        }
        }






    }



    public void btnParkOnAction(ActionEvent actionEvent) {
        if (checkselectdrive() ){
            Alert alert=new Alert(Alert.AlertType.ERROR,"NOT SELECTED DRIVER AND VEHICLE",
                    ButtonType.OK);
            alert.show();
        }else {

            for(int i = 0;i<DataBase.vehicleDelivery.size();i++){

                if(clickValue.equals(DataBase.vehicleDelivery.get(i).getVehicleNumber())){
                    DataBase.vehicleDelivery.remove(i);
                }
            }

            ParkVehicle p1 = new ParkVehicle((String) cmbSelectVehicle.getValue(), lblVehicleType.getText(), lblSlotNumber1.getText(), lblTime.getText());
            DataBase.vehiclePark.add(p1);

            for(int j =0;j<DataBase.slotTable.size();j++){

                if(lblSlotNumber1.getText().equals(DataBase.slotTable.get(j).getSlotNumber())){
                    DataBase.slotTable.get(j).setSlotStatus("used");

                }
            }




        }


    }

    public void initialize () throws InterruptedException {


            cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clickValue = String.valueOf(newValue);

            for(int i=0;i<DataBase.vehicleArrayList.size();i++){

                if(clickValue.equals(DataBase.vehicleArrayList.get(i).getVehicleNumber())){
                    setslot(DataBase.vehicleArrayList.get(i).getVehicleType());
                }
            }
        });


        LocalDate();
        LocalTime();

        for (Vehicle d1:DataBase.vehicleArrayList
             ) {
            cmbSelectVehicle.getItems().add(d1.getVehicleNumber());
        }

        for (Driver d2:DataBase.driverArrayList
             ) {
            cmbDriver.getItems().add(d2.getName());
        }


    }


    public void SelectVehicleOnAction(ActionEvent actionEvent) {

        for(int i=0;i<DataBase.vehicleArrayList.size();i++){

            if(cmbSelectVehicle.getValue().equals(DataBase.vehicleArrayList.get(i).getVehicleNumber())){

                lblVehicleType.setText(DataBase.vehicleArrayList.get(i).getVehicleType());
            }
        }
    }



    private void setslot(String vehicletype) {





        for (int i=0; i<DataBase.slotTable.size(); i++){
            for (int j=0; j<DataBase.slotTable.size(); j++){
                if (vehicletype.equals(DataBase.slotTable.get(i).getSlotVehicleType()) && DataBase.slotTable.get(i).getSlotStatus().equals("notused")) {
                    lblSlotNumber1.setText(DataBase.slotTable.get(i).getSlotNumber());

                    return;
                }
            }
        }

    }

}
