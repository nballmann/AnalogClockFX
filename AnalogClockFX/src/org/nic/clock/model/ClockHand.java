package org.nic.clock.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClockHand extends Canvas {
	
	public static final int HOUR_HAND = 25;
	public static final int MINUTE_HAND = 35;
	public static final int SECOND_HAND = 40;
	
	private DoubleProperty hLength;
	private DoubleProperty hWidth;
	private IntegerProperty tickCount;
	private IntegerProperty actualTick;
	
	private GraphicsContext gc;
	
	public void setHLength(double length) { this.hLength.set(length); }
	public void setHWidth(double width) { this.hWidth.set(width); }
	public void setTickCount(int tick) { this.tickCount.set(tick); }
	public void setActualTick(int tick) { this.actualTick.set(tick); }
	
	
	public ClockHand(final double width, final double height, final int handType) {
		
		setWidth(width);
		setHeight(height);
		
		tickCount = new SimpleIntegerProperty(60);
		actualTick = new SimpleIntegerProperty(0);
		
		hLength = new SimpleDoubleProperty(getWidth()*handType/100);
		hWidth = new SimpleDoubleProperty((1/handType)*175+5);
		
		gc = getGraphicsContext2D();
		
		gc.translate(getWidth()/2, getHeight()/2);
		gc.setStroke(Color.WHITE);
		gc.setLineWidth(hWidth.get());
		gc.strokeLine(0, 0, hLength.get(), 0);
		
	}
	
	public void setHandArc(final int arcInDegrees) {
		
		rotateProperty().set(Math.toDegrees(arcInDegrees));
		
	}
	
	
	

}
