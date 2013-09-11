package org.nic.clock.controller;

import javafx.fxml.FXML;

import org.nic.clock.ClockApp;
import org.nic.clock.util.ControllerInterface;

public class WindowControllsController implements ControllerInterface {
	
	private ClockApp clockApp;
	
	
	
	@FXML
	private void handleWindowClose() {
		
		System.exit(0);
		
	}
	
	@FXML
	private void handleWindowMinimize() {
		
		
		
	}
	
	@FXML
	private void handleWindowMaximize() {
		
		
		
	}

	@Override
	public void setMainApp(ClockApp clockApp) {
		this.clockApp = clockApp;
	}

}
