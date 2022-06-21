package de.juliuswendland.selfdrivingcar;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class Car {
	
	int x = 0, y = 0;
	int width = 0, height = 0;
	boolean forward = false, backward = false;
	boolean left = false, right = false;

	public Car(int startingX, int startingY, int width, int height) {
		
		this.x = startingX;
		this.y = startingY;
		this.width = width;
		this.height = height;
		
		Controls controls = new Controls(this);
		Main.frame.addKeyListener(controls);
		
	}
	
	public void update() {
		
		Timer updateTimer = new Timer();
		updateTimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				move();
				
			}
		}, 0, 25);
		
	}
	
	public void move() {
		
		if(this.forward) {
			this.y -= 2;
		} else if(this.backward) {
			this.y += 2;
		}
		
		if(this.left) {
			this.x -= 2;
		} else if(this.right) {
			this.x += 2;
		}
		
	}
	
	public void draw(Graphics g) {
		
		g.fillRect(
			this.x - this.width / 2,
			this.y - this.height / 2,
			this.width,
			this.height
		);
		
	}

}
