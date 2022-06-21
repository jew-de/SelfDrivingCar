package de.juliuswendland.selfdrivingcar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	/**
	 * @author juliuswendland
	 */
	
	static JFrame frame;

	public static void main(String[] args) {
		
		frame = new Frame();
		
		Car car = new Car(50, 150, 30, 50);
		car.update();
		
		JLabel carLabel = new CarLabel(car);
		
		frame.add(carLabel);
//		frame.addKeyListener(new Controls());
		
	}
	
}
