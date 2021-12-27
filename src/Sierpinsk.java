package com.masondierkes;

import java.awt.*;

public class Sierpinsk {

    private Graphics graphics;
    private int width, height;

    public Sierpinsk(Graphics g) {
        this.graphics = g;
    }

    public void draw(int width, int height){
        // Set coordinates to the size of the screen

        int length = Math.min(width, height);
        this.width = width;
        this.height = height;

        drawTriangle(width, height, length);
    }

    private void drawTriangle(int x, int y, int length){
        if (length < 1 || x > width ||  y > height) { return; }

        int endX = x + length;
        int endY = y + length;
        int nextLength = length / 2;

        graphics.drawLine(x - length, endY, endX, endY);
        graphics.drawLine(endX, y - length, endX, endY);
        graphics.drawLine(x - length, endY, endX, y - length);

        drawTriangle(x / 2 , y / 2, length /2);
        drawTriangle(x/2, y, length/2);
        drawTriangle((x / 2) + x, (y/2) , nextLength);
    }




}
