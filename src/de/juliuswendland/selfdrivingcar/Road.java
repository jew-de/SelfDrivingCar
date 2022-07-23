package de.juliuswendland.selfdrivingcar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Road {

	int laneCount;
	double width;
	double x;
	
	double left;
	double right;
	int top = - Utils.INFINITY;
	int bottom = Utils.INFINITY;
	
	/**
	 * 
	 * @param width		the width of the road
	 * @param x			the x-coordinate the road is based on
	 * @param laneCount	the number of lanes within the road
	 */
	public Road(double width, double x, int laneCount) {
		
		this.width = width;
		this.x = x;
		this.laneCount = laneCount;
		
		this.left = x - width / 2;
		this.right = x + width / 2;
		
	}
	
	/**
	 * 
	 * @param laneIndex	the index of the lane
	 * @return			the center (x) of the lane given
	 */
	public double getLaneCenter(int laneIndex) {
		
		double laneWidth = this.width / this.laneCount;
		double laneCenter = this.left + laneWidth / 2 + Math.min(laneIndex, this.laneCount - 1) * laneWidth;
		
		return laneCenter;
		
	}
	
	public void draw(Graphics2D graphics2D) {
		
		//draw the lines
		BasicStroke lineStroke = new BasicStroke(5);
		BasicStroke dashedLineStroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		
		for(int i = 0; i <= this.laneCount; i++) {
			graphics2D.setColor(Color.WHITE);
			
			if(i > 0 && i < this.laneCount) {
				graphics2D.setStroke(dashedLineStroke);
			} else {
				graphics2D.setStroke(lineStroke);
			}
			
			double x = Utils.lerp(this.left, this.right, (double) i / this.laneCount);
			graphics2D.draw(new Line2D.Double(x, this.top, x, this.bottom));
		}
		
	}

}
