package org.nic.clock;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.nic.clock.controller.ClockController;
import org.nic.clock.model.Clock;

public class ClockApp extends Application {

	
	
	
	@Override
	public void start(Stage stage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/clock_view.fxml"));
			
			StackPane clockView = (StackPane) loader.load();
			
			Clock clock = new Clock();
			
			clockView.getChildren().add(clock);
			
			ClockController clockController = loader.getController();
			clockController.setMainApp(this);
			
			Scene scene = new Scene(clockView);
			
			stage.setScene(scene);
			stage.setHeight(650);
			stage.setWidth(650);
			stage.setTitle("Clock");
			
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
