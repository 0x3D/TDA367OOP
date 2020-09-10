package com.teamjeaa.obpaint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public final class ObPaint extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().
				getResource("obPaint.fxml")));
		primaryStage.setTitle("ObPaint");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
