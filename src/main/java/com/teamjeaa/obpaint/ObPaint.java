package com.teamjeaa.obpaint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.ResourceBundle;

public final class ObPaint extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().
				getResource("obPaint.fxml")));
		ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
		primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
