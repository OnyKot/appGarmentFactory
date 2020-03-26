package me.onykot.app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import me.onykot.app.helper.WindowHelper;
import ua.oxooocb.fxlib.controller.*;

import java.sql.SQLException;

public class Loader extends ControllerQueue {

    @FXML
    public Button btn_reg;
    /**
     * Хлам с FXML.
     */

    @FXML
    private Button exitbtn;
    @FXML
    private TextArea tb_password;
    @FXML
    private TextArea tb_login;
    @FXML
    private Button btn_log;

    /**
     * Регистрируем приложение.
     */

    public Loader() {
        //0 - ячейка в хеше.
        super(0);
    }

    /**
     * Регистрируем ивенты.
     */

    @Override
    public void register() {
        onClick();
    }

    /**
     * Ивент на клик.
     */

    private void onClick() {
        //Если кликнули на pane.
        exitbtn.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        btn_log.setOnMouseClicked(mouseEvent -> {
            if(tb_login.getText() == null || tb_login.getText().equalsIgnoreCase("") || tb_password.getText() == null || tb_password.getText().equalsIgnoreCase("")){
                WindowHelper.infoBox("Необходимо указать данные от аккаунта", "Необходимо указать данные");
                return;
            }
            try {
                Starter.sqlHelper.login(tb_login.getText(), tb_password.getText());
            } catch (SQLException | IllegalStateException e ) {
                if(e.getMessage().equalsIgnoreCase("Invalid login data"));
                WindowHelper.errorBox("Не верное имя пользователя или пароль", "Не могу войти в аккаунт");
                e.printStackTrace();
            }

        });

        btn_reg.setOnMouseClicked(mouseEvent -> {
            WindowHelper.opemRegistration();
        });
    }
}