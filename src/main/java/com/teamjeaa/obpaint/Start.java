package com.teamjeaa.obpaint;


import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public final class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method starts up JavaFX and initializes the Model
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Parent root = setupScene(primaryStage);
    }

    private Parent setupScene(Stage primaryStage) {
        Parent root = new MainView();

        primaryStage.setOnCloseRequest(e->{
            try{stop();}
            catch (Exception exception){exception.printStackTrace();}
            Platform.exit();
            System.exit(0);
        });

        ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
        primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
        primaryStage.getIcons().add(new Image("images/logo.png"));
        primaryStage.setScene(new Scene(root, 900, 675));
        primaryStage.setMinHeight(680);
        primaryStage.setMinWidth(900);
        primaryStage.show();
        Model.primaryStage = primaryStage;
        return root;
    }
}
