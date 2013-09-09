package org.nic.clock.model;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class Clock  extends Canvas {

	final float[] dist = { 0.90f, 0.95f, 1.0f };
	final Color[] colors = { Color.DARKGRAY, Color.LIGHTGRAY, Color.DARKGRAY };
	
	private GraphicsContext gc;
	
	public Clock() {
		
		setHeight(600);
		setWidth(600);
		
		gc = getGraphicsContext2D();
		
		gc.setFill(drawBackground(colors[0], colors[1]));
		gc.fillOval(0, 0, getWidth(), getHeight());
		gc.setFill(drawBackground(Color.WHITE, Color.BLACK));
		gc.fillOval(300-30, 300-30, 60, 60);
		
		gc.translate(getWidth()/2, getHeight()/2);
		
		gc.setStroke(Color.WHITE);
		
		for(int i = 0; i< 24; i++) {
			
			gc.rotate(i * (360/24));
			gc.strokeLine(200, 0, 220, 0);
			gc.rotate(-(i * (360/24)));
			
		}
		
		
//		gc.rotate(-Math.toRadians(-180+70));
//		gc.translate(-getWidth()/2, -getHeight()/2);
		
//		gc.fillOval(300, 300, 300, 300);

	}
	
	
	public RadialGradient drawBackground(final Color firstColor, final Color secondColor) {
		
		return new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
				CycleMethod.REFLECT,
				new Stop(0.0, firstColor),
				new Stop(1.0, secondColor));
		
	}

	public RadialGradient drawAnchor(final Color firstColor, final Color secondColor) {

		return new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
				CycleMethod.REFLECT,
				new Stop(0.0, firstColor),
				new Stop(1.0, secondColor));

	}
	
	
}
