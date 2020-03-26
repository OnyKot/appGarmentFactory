package me.onykot.app;

import javafx.application.Application;
import javafx.stage.Stage;
import me.onykot.app.helper.SQLHelper;
import ua.oxooocb.fxlib.utils.StageUtils;

public class Starter extends Application {


    public static SQLHelper sqlHelper;
    @Override
    public void start(Stage stage) throws Exception {
        sqlHelper = new SQLHelper();
        StageUtils.createApplication(FXML.LOADER.getFXML(), "Application", 600, 400, FXML.LOADER.getCSS(), FXML.LOADER.getIcon(), true);

    }
}
