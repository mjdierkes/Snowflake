package com.masondierkes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		g.setColor(Color.BLUE);

		int length = (width < height) ? width/3 : height/3;
//		drawBlizzard(g, width, height, width/13);

		Sierpinsk sierpinsk = new Sierpinsk(g);
		sierpinsk.draw(width, height);
	}

	private void drawStar(Graphics g, int x1, int y1, int length, int degrees) {
		double radians = Math.toRadians(degrees);
		if(degrees >= 360)
			return;

		int x2 = x1 + (int) (Math.cos(radians) * length);
		int y2 = y1 + (int) (Math.sin(radians) * length);
		g.drawLine(x1, y1, x2, y2);

		drawStar(g, x1, y1, length, degrees + 60);
	}

	private void drawSnowflake(Graphics g, int x1, int y1, int length, int degrees, int levels, Color color) {
		double radians = Math.toRadians(degrees);
		g.setColor(color);

		if(degrees >= 360)
			return;

		int x2 = x1 + (int) (Math.cos(radians) * length);
		int y2 = y1 + (int) (Math.sin(radians) * length);
		g.drawLine(x1, y1, x2, y2);

		drawSnowflake(g, x1, y1, length, degrees + 60, levels, color);

		if(levels > 0)
			drawSnowflake(g, x2, y2, length / 4, 0, levels - 1, color);
	}


	private void drawBlizzard(Graphics g, int width, int height, int snowFlakes){
		Random random = new Random();
		Color[] colors = new Color[] {Color.blue, Color.green, Color.magenta, Color.red};

		if(snowFlakes < 0) { return; }
		drawSnowflake(g, random.nextInt(width), random.nextInt(height), random.nextInt(30), 0, 2, colors[random.nextInt(colors.length)] );

		drawBlizzard(g, width, height, snowFlakes - 1);
	}



}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
