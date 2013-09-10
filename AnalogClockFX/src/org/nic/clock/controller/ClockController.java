package org.nic.clock.controller;

import java.util.Calendar;
import java.util.Locale;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import org.nic.clock.ClockApp;
import org.nic.clock.model.ClockHand;

public class ClockController {
	
	private ClockApp clockApp;
	
	private ObjectProperty<Calendar> cal;
	
	private DoubleProperty hours;
	private DoubleProperty minutes;
	private DoubleProperty seconds;
	
	private ClockHand hoursHand;
	private ClockHand minutesHand;
	private ClockHand secondsHand;
	
	private boolean isRunning = false;
	
	public ClockController() {
		
		cal = new SimpleObjectProperty<Calendar>();
		cal.set(Calendar.getInstance(Locale.GERMANY));
		
		hours = new SimpleDoubleProperty(cal.get().get(Calendar.HOUR));
		minutes = new SimpleDoubleProperty(cal.get().get(Calendar.MINUTE));
		seconds = new SimpleDoubleProperty(cal.get().get(Calendar.SECOND));
		
		hoursHand = new ClockHand(ClockHand.HOUR_HAND);
		minutesHand = new ClockHand(ClockHand.MINUTE_HAND);
		secondsHand = new ClockHand(ClockHand.SECOND_HAND);
		
		hoursHand.mouseTransparentProperty().set(true);
		minutesHand.mouseTransparentProperty().set(true);
		secondsHand.mouseTransparentProperty().set(true);
		
		hours.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> obs,
					Number oldValue, Number newValue) {

				hoursHand.rotateProperty().set(newValue.doubleValue() * 
						360f/12f-(3f*360f/12f)+360f/12f*minutes.get()/60f);
				System.out.println("changed Hour " + (newValue.doubleValue() * 
						360.00/12.00-(3.00*360.00/12.00)+360f/12f*minutes.get()/60f));
				
			}
			
		});
		
		minutes.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> obs,
					Number oldValue, Number newValue) {

				double temp = newValue.doubleValue() * (360/60)-(15*360/60);
				minutesHand.rotateProperty().set(temp);
				
				if(temp%6==0 && temp!=0 && temp!=60)
					hours.set(hours.get() + newValue.doubleValue()*60/100);
				System.out.println("changed Minute");
				
			}
			
		});
		
		seconds.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> obs,
					Number oldValue, Number newValue) {

				if(oldValue!=newValue) {
					secondsHand.rotateProperty().set((Double) newValue * 
							(360/60)-(15*360/60));
					System.out.println("changed Second");
				}
			}
			
		});
		
		seconds.set(11);
		minutes.set(12);
		hours.set(13);
		
		isRunning = true;
		
		ClockService service = new ClockService();
		service.start();
		
	}
	
	public ClockHand getHoursHand() { return hoursHand; }
	public ClockHand getMinutesHand() { return minutesHand; }
	public ClockHand getSecondsHand() { return secondsHand; }
	
	public void setMainApp(ClockApp clockApp) {
		this.clockApp = clockApp;
	}
	
	public void changeRunningStatus() {
		isRunning = !isRunning;
	}
	
	private class ClockService extends Service<Integer> {

		@Override
		protected Task<Integer> createTask() {

			return new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {

					while(isRunning) {
						
						cal.set(Calendar.getInstance());
						
						Thread.sleep(1000);
						
						hours.set(cal.get().get(Calendar.HOUR));
						minutes.set(cal.get().get(Calendar.MINUTE));
						seconds.set(cal.get().get(Calendar.SECOND));
						
					}
					
					return null;
				}
				
			};
		}
		
	
	}
	

}
