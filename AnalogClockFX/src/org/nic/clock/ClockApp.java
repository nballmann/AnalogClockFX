package org.nic.clock;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import org.nic.clock.controller.ClockController;
import org.nic.clock.model.Clock;

public class ClockApp extends Application {

	private double initialX;
	private double initialY;
	
	
	@Override
	public void start(Stage stage) {
		
		stage.initStyle(StageStyle.TRANSPARENT);
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/clock_view.fxml"));
			
			StackPane clockView = (StackPane) loader.load();
			
			final Clock clock = new Clock();

			clock.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					if(event.getButton() == MouseButton.PRIMARY) {
						
						initialX = event.getSceneX();
						initialY = event.getSceneY();
						
					}
					
				}
				
			});
			
			clock.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					if(event.getButton() == MouseButton.PRIMARY) {
						
						clock.getScene().getWindow().setX(event.getScreenX() - initialX);
						clock.getScene().getWindow().setY(event.getScreenY() - initialY);
						
					}
					
				}
				
			});

			ClockController calendarController = new ClockController();


			clockView.getChildren().add(clock);
			clockView.getChildren().add(calendarController.getHoursHand());
			clockView.getChildren().add(calendarController.getMinutesHand());
			clockView.getChildren().add(calendarController.getSecondsHand());
			
			ClockController clockController = loader.getController();
			clockController.setMainApp(this);
			
			Scene scene = new Scene(clockView);
			scene.setFill(null);
			
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
