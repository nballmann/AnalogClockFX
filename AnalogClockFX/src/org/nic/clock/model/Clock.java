package org.nic.clock.model;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Clock  extends Canvas {

	final float[] dist = { 0.90f, 0.95f, 1.0f };
	final Color[] colors = { Color.DARKGRAY, Color.LIGHTGRAY, Color.DARKGRAY };
	
	private GraphicsContext gc;
	
	public Clock() {
		
		setHeight(600);
		setWidth(600);
		
		gc = getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);//drawBackground(colors[0], colors[1]));
		gc.fillOval(0, 0, getWidth(), getHeight());
		gc.setFill(drawBackground(Color.WHITE, Color.BLACK));
//		gc.fillOval(300-30, 300-30, 60, 60);
		
		gc.translate(getWidth()/2, getHeight()/2);
		
		gc.setStroke(Color.WHITE);
		gc.setFont(new Font("Segoe UI Bold", 26));
		gc.setFill(Color.RED);
		
		for(int i = 0; i< 12; i++) {
			
			gc.rotate(i * (360/12));
			gc.strokeLine(200, 0, 220, 0);
			
			gc.rotate(360/60);
			
			for(int j = 0; j < 4; j++) {
				
				gc.rotate(j * (360/60));
				
				gc.strokeLine(200, 0, 210, 0);
				
				gc.rotate(-(j * (360/60)));
			}
			
			gc.rotate(-(360/60));
			
			gc.translate(230, 0);
			gc.rotate(90);
			gc.setFill(Color.RED);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.fillText(String.valueOf(i+1), 0, 0);
			
			gc.rotate(-90);
			gc.translate(-230, 0);
			
			gc.rotate(-(i * (360/12)));
			
			
		}
		
		rotateProperty().set(-2*360/12);

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
