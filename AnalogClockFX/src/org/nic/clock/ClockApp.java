package org.nic.clock;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import org.nic.clock.controller.ClockController;
import org.nic.clock.controller.WindowControllsController;

public class ClockApp extends Application {

	private static final int APP_WIDTH = 300;
	private static final int APP_HEIGHT = 300;
	
	private HBox windowControlls;
	
	private Stage stage;
	
	@Override
	public void start(Stage stage) {
		
		this.stage = stage;
		
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setHeight(APP_HEIGHT);
		stage.setWidth(APP_WIDTH);
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/clock_view.fxml"));
			
			StackPane clockView = (StackPane) loader.load();
			
			ClockController clockController = loader.getController();
			clockController.setMainApp(this);
			clockController.init();

			clockView.getChildren().add(clockController.getClock());
			clockView.getChildren().add(clockController.getHoursHand());
			clockView.getChildren().add(clockController.getMinutesHand());
			clockView.getChildren().add(clockController.getSecondsHand());
			
			initWindowControlls();
			
			Scene scene = new Scene(clockView);
			scene.setFill(null);
			
			stage.setScene(scene);
			stage.setTitle("Clock");
			
			windowControlls.setTranslateY(-stage.getHeight()/2 + windowControlls.getPrefHeight());
			
			clockView.getChildren().add(windowControlls);
			
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
	
	private void initWindowControlls() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/WindowControllsView.fxml"));
			
			windowControlls = (HBox) loader.load();
			
			WindowControllsController winController = loader.getController();
			winController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Stage getStage() { return stage; }

	public static void main(String[] args) {
		launch(args);
	}
}
