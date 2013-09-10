package org.nic.clock;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.nic.clock.controller.ClockController;
import org.nic.clock.model.Clock;

public class ClockApp extends Application {

	
	
	
	@Override
	public void start(Stage stage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/clock_view.fxml"));
			
			StackPane clockView = (StackPane) loader.load();
			
			Clock clock = new Clock();
			ClockController calendarController = new ClockController();
			
			
			clockView.getChildren().add(clock);
			clockView.getChildren().add(calendarController.getHoursHand());
			clockView.getChildren().add(calendarController.getMinutesHand());
			clockView.getChildren().add(calendarController.getSecondsHand());
			
			ClockController clockController = loader.getController();
			clockController.setMainApp(this);
			
			Scene scene = new Scene(clockView);
			
			stage.setScene(scene);
			stage.setHeight(650);
			stage.setWidth(650);
			stage.setTitle("Clock");
			
			
			stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent arg0) {
					System.exit(0);
				}
				
			});
			
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
