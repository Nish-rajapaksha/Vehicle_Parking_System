package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane LoginContext;
    public TextField txtUserName;
    public PasswordField pwdPassword;
    int attemps = 0;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {

        String tempUserName = txtUserName.getText();
        String tempPassword = pwdPassword.getText();
        attemps ++;
        if (attemps<=3) {

            if (tempUserName.equals("admin") && tempPassword.equals("1234")) {


                 Stage stage =(Stage)LoginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ParkingDeliveryForm.fxml"))));
            }



            else {

                new Alert(Alert.AlertType.WARNING, "Wrong Password Try again").show();
            }
        }
        else {

            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);
        }




    }

    public void CanselOnAction(ActionEvent actionEvent) {

        Stage stage= (Stage) LoginContext.getScene().getWindow();
        stage.close();


    }


}
