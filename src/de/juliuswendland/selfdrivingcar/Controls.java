package de.juliuswendland.selfdrivingcar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
	
	private Car car;
	
	public Controls(Car car) {
		
		this.car = car;
		
	}

	@Override
	@Deprecated
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			car.forward = true;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			car.left = true;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			car.backward = true;
		} else if(e.getKeyCode() == KeyEvent.VK_D) {
			car.right = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			car.forward = false;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			car.left = false;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			car.backward = false;
		} else if(e.getKeyCode() == KeyEvent.VK_D) {
			car.right = false;
		}
		
	}

	
	
}
