package de.juliuswendland.selfdrivingcar;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = -2188595306683284107L;
	public static final int SCREENWIDTH = 1000;
	public static final int SCREENHEIGHT = 800;

	public Frame() {
		
		this.setTitle("Self-Driving Car in Java");
		this.setSize(Frame.SCREENWIDTH, Frame.SCREENHEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.requestFocus();
		this.revalidate();
		this.repaint();
		
	}

}
