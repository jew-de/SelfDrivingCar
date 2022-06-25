package de.juliuswendland.selfdrivingcar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	/**
	 * @author juliuswendland
	 * 
	 * INSPIRED BY FreeCodeCamp.org (and kind of copied tbh)
	 */
	
	static JFrame frame;

	public static void main(String[] args) {
		
		frame = new Frame();
		
		Road road = new Road(CarLabel.CAR_LABEL_WIDTH * 0.9, CarLabel.CAR_LABEL_WIDTH / 2, 3);
		
		Car car = new Car(50, 150, 30, 50);
		car.update();
		
		JLabel carLabel = new CarLabel(car, road);
		
		frame.add(carLabel);

	}
	
}
