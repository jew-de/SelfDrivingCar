package de.juliuswendland.selfdrivingcar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class CarLabel extends JLabel {

	private static final long serialVersionUID = 455836144139105696L;
	private Car car;

	public CarLabel(Car car) {
		
		this.setBounds(150, 0, 200, Frame.SCREENHEIGHT);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.revalidate();
		this.car = car;
		
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//turn off anti aliasing for better quality
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		//draw the car
		car.draw(g);
		
		repaint();
		
	}

}
