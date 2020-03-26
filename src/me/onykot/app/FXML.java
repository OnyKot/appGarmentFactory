package me.onykot.app;

import javafx.fxml.FXMLLoader;

import java.io.InputStream;

public enum FXML {
    //Инициализируем путь к FXML файлу, путь к CSS файлу, путь к иконке.
    LOADER(new FXMLLoader(Starter.class.getResource("/resources/loader.fxml")), Starter.class.getResourceAsStream("/resources/loader.css"), Starter.class.getResourceAsStream("/resources/icon.png"));

    private final FXMLLoader fxmlLoader;
    private final InputStream css;
    private final InputStream icon;

    FXML(FXMLLoader fxmlLoader, InputStream css, InputStream icon) {
        this.fxmlLoader = fxmlLoader;
        this.css = css;
        this.icon = icon;
    }

    /**
     * Получить FXML файл.
     */

    public FXMLLoader getFXML() {
        return fxmlLoader;
    }

    /**
     * @return CSS файл.
     */

    public String getCSS() {
        return css.toString();
    }

    /**
     * @return Иконка.
     */

    public InputStream getIcon() {
        return icon;
    }

}
