package de.juliuswendland.selfdrivingcar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class CarLabel extends JLabel {

	private static final long serialVersionUID = 455836144139105696L;
	private Car car;
	private Road road;
	
	public static final int CAR_LABEL_WIDTH = 200;

	public CarLabel(Car car, Road road) {
		
		this.setBounds(150, -Utils.INFINITY/2, CarLabel.CAR_LABEL_WIDTH, Utils.INFINITY);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.revalidate();
		this.car = car;
		this.road = road;
		
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//turn off anti aliasing for better quality
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		//draw the car
		this.road.draw(g2d);
		this.car.draw(g2d);
		
		this.setLocation(150, (int) ((int) -this.car.y + Frame.SCREENHEIGHT * 0.7));
		
		repaint();
		
	}

}
