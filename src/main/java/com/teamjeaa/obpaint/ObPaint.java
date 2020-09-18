package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.ResourceBundle;

public final class ObPaint extends Application {
	private Tool selectedTool;
	private ToolFactory toolFactory = new ConcreteToolFactory();


	public static  Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().
				getResource("obPaint.fxml")));
		ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
		primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
		primaryStage.getIcons().add(new Image("images/logo.png"));
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();
		ObPaint.primaryStage = primaryStage;
	}


	public static void main(String[] args) {
		launch(args);
	}

	public Tool getSelectedTool() {
		return selectedTool;
	}

	public void setSelectedTool(Tool selectedTool) {
		this.selectedTool = selectedTool;
	}

}
