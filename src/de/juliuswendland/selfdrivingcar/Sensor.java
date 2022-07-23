package de.juliuswendland.selfdrivingcar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Sensor {

	private Car car;
	private int rayCount;
	private int rayLength;
	
	public static final int RAY_SPREAD = 45;
	
	ArrayList<Line2D> rays = new ArrayList<>();

	public Sensor(Car car, int rayCount, int rayLength) {
		
		this.car = car;
		this.rayCount = rayCount;
		this.rayLength = rayLength;
		
		for(int i = 0; i < this.rayCount; i++) {
			
			double temp = this.rayCount - 1;
			double t = i / temp;
			
			double rayAngle = Utils.lerp(	
				Sensor.RAY_SPREAD / 2,
				-Sensor.RAY_SPREAD / 2,
				t
			);
			
			Line2D ray = new Line2D.Double(	
				this.car.x,
				this.car.y,
				this.car.x - Math.sin(Math.toRadians(rayAngle)) * this.rayLength,
				this.car.y - Math.cos(Math.toRadians(rayAngle)) * this.rayLength		
			);
			
			this.rays.add(ray);
			
		}
		
	}
	
	public void update() {
		
		
		for(int i = 0; i < this.rays.size(); i++) {
			
			double temp = this.rays.size() - 1;
			double t = i / temp;
			
			double rayAngle = Utils.lerp(
				Sensor.RAY_SPREAD / 2, 
				- Sensor.RAY_SPREAD / 2, 
				t
			);
			
			rays.get(i).setLine(
				this.car.x,
				this.car.y,
				this.car.x - Math.sin(Math.toRadians(rayAngle)) * this.rayLength,
				this.car.y - Math.cos(Math.toRadians(rayAngle)) * this.rayLength
			);
			
		}
		
	}
	
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(Color.YELLOW);
		g2d.setStroke(new BasicStroke(5));
		
		for(int i = 0; i < this.rays.size(); i++) {
			
			Line2D ray = this.rays.get(i);
			g2d.draw(ray);
			
		}
		
	}

}
