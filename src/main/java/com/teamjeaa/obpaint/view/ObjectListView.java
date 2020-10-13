package com.teamjeaa.obpaint.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class ObjectListView extends ScrollPane {

    public ObjectListView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListView.fxml"));
        //fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
