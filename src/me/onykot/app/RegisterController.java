package me.onykot.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ua.oxooocb.fxlib.controller.ControllerQueue;

public class RegisterController extends ControllerQueue {
    @FXML
    private Button getReg_btn;
    @FXML
    public TextField password;
    @FXML
    public TextField login;
    @FXML
    public Button reg_btn;

    public void exit(Button exit)
    {

    }

    public RegisterController() {
        super(0);
    }

    @Override
    public void register() {
        click();
    }



    public void click(){
        reg_btn.setOnMouseClicked(mouseEvent -> {
            String passwordTxt = password.getText();


            String loginTxt = login.getText();


            System.out.println(loginTxt);
            Starter.sqlHelper.register(loginTxt, passwordTxt, Roles.MANEGER);
        });
    }
}
