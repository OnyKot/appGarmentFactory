package me.onykot.app.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.onykot.app.FXML;
import me.onykot.app.FXMLz;
import me.onykot.app.Starter;
import ua.oxooocb.fxlib.stage.StageBuilder;
import ua.oxooocb.fxlib.utils.StageUtils;

import java.io.IOException;
import java.net.URL;

public class WindowHelper {

    public static void infoBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        infoBox(infoMessage, titleBar, null);
    }


    public static void errorBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        errorBox(infoMessage, titleBar, null);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public static void errorBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }


    public static void showWindow1(){


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("/resources/z1.fxml"));
            fxmlLoader.setLocation(new URL("https://example.com"));
            Parent root = (Parent) FXMLLoader.load(Starter.class.getResource("/resources/z1.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Application");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void  opemRegistration(){
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("/resources/Register.fxml"));
            Parent root = (Parent) FXMLLoader.load(Starter.class.getResource("/resources/Register.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Регистрация");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
