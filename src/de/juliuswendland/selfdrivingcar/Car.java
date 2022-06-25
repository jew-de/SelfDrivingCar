package de.juliuswendland.selfdrivingcar;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class Car {
	
	double x = 0, y = 0;
	int width = 0, height = 0;
	boolean forward = false, backward = false;
	boolean left = false, right = false;
	double speed = 0;
	double angle = 0;
	
	private static final double ACCELERATION = 0.2;
	private static final int MAXIMUM_SPEED = 3;
	private static final double FRICTION = 0.05;

	public Car(double startingX, double startingY, int width, int height) {
		
		this.x = startingX;
		this.y = startingY;
		this.width = width;
		this.height = height;
		
		Controls controls = new Controls(this);
		Main.frame.addKeyListener(controls);
		
		update();
		
	}
	
	private void update() {
		
		Timer updateTimer = new Timer();
		updateTimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				move();
			}
		}, 0, 15);
		
	}
	
	private void move() {
		
		//set the speed according to inputs
		if(this.forward) {
			speed += ACCELERATION;
		}
		if(this.backward) {
			speed -= ACCELERATION;
		}
		
		//set the angle according to inputs
		if(this.speed > 0) {
			if(this.left)
				this.angle += 1;
			if(this.right)
				this.angle -= 1;
		} else if(this.speed < 0) {
			if(this.left)
				this.angle -= 1;
			if(this.right)
				this.angle += 1;
		}
		
//		if(this.left)
//			this.angle += 1;
//		if(this.right)
//			this.angle -= 1;
		
		//implement a maximum speed
		if(this.speed > Car.MAXIMUM_SPEED) 
			this.speed = Car.MAXIMUM_SPEED;
		if(this.speed < -Car.MAXIMUM_SPEED / 2)
			this.speed = -Car.MAXIMUM_SPEED / 2;
		
		//implement friction slowing down the car
		if(this.speed > 0)
			this.speed -= Car.FRICTION;
		if(this.speed < 0)
			this.speed += Car.FRICTION;
		//fix that the car is constantly moving
		if(Math.abs(this.speed) < Car.FRICTION)
			this.speed = 0;
		
		//move the car (using the unit circle)
		this.x -= Math.sin(Math.toRadians(this.angle)) * this.speed;
		this.y -= Math.cos(Math.toRadians(this.angle)) * this.speed;
		
	}
	
	public void draw(Graphics2D graphics2D) {
		
		graphics2D.setColor(Color.BLACK);
		//create a rectangle centered around coordinates
		Rectangle2D rectangle = new Rectangle2D.Double(
				- this.width / 2,
				- this.height / 2,
				this.width,
				this.height
		);
		
		//transform (rotate) the rectangle according to the angle
		AffineTransform transform = new AffineTransform();
		transform.translate(this.x, this.y);
		transform.rotate(-Math.toRadians(angle));
		
		//draw the car
		Shape rotatedRectangle = transform.createTransformedShape(rectangle);
		graphics2D.fill(rotatedRectangle);
		
//		g.fillRect(
//			(int) this.x - this.width / 2,
//			(int) this.y - this.height / 2,
//			this.width,
//			this.height
//		);
		
	}

}
