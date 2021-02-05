/*
 * File: GraphicsHierarchy.java
 * Name: 
 * Section Leader: 
 * ----------------------------
 * This file is the starter file for the GraphicsHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class GraphicsHierarchy extends GraphicsProgram {	
	public void run() {
	
	 
		 /*  WINDOW  */
			
		//window size
		final int window_width = 800;
		final int window_height = 600;
		
		this.setSize(window_width, window_height);
		
		 /*  BOX  */
		
		//가변
		//box number 
		final int GOBJECT = 0, GLABEL = 1, GLINE = 2, GOVAL = 3, GRECT = 4;
		//number of classe\
		final int NUM_OF_BOX = 3;
		//box size 
		final int box_width = 150;
		final int box_height = 45;	
		
		//불변
		//box position 
		int[] x_box = new int[NUM_OF_BOX];
		int[] y_box = new int[NUM_OF_BOX];

		final int interval = (window_width - 4 * box_width) / x_box.length; // interval between boxes
	
		x_box[GOBJECT] = (((NUM_OF_BOX) *(interval) + (NUM_OF_BOX - 1)*box_width) / 2) - (box_width / 2) ;
		y_box[GOBJECT] =  50;

		for(int i = 1; i< NUM_OF_BOX; i++)
		{
			x_box[i] = box_width * (i - 1)+ interval * i;
			y_box[i] = 300;

		}
		
		//boxes
		
		GObject[] box_arr = new GRect[NUM_OF_BOX];
		
		for(int i = 0; i < NUM_OF_BOX; i++)
		{
			GObject box = new GRect(box_width, box_height);
			box_arr[i] = box;
		}
		
		/* 
		 * Labels */
		
		//labels
		GObject label_GObject = new GLabel("GObject");
		GObject label_GLabel  = new GLabel("GLabel");
		GObject label_GLine   = new GLabel("GLine");
		GObject label_GOval   = new GLabel("GOval");
		GObject label_GRect   = new GLabel("GRect");	
		GObject label_GG   = new GLabel("GG");

		GObject[] label_arr = {label_GObject,label_GLabel,label_GLine,label_GOval,label_GRect,label_GG};
		
		//label position
		double[] x_label = new double[NUM_OF_BOX];
		double[] y_label = new double[NUM_OF_BOX];
		for(int i = 0; i < NUM_OF_BOX;i++)
		{
			x_label[i] =  x_box[i] + box_width / 2 - label_arr[i].getWidth() / 2;
			y_label[i] =  y_box[i] + (box_height / 2) + label_arr[i].getHeight() / 2;
		}
		
		/*
		 * lines */
		
		
		// starting position 
		double x_line_start = x_box[GOBJECT] + box_width / 2;
		double y_line_start = y_box[GOBJECT] + box_height;
	
		// ending position
		double[] x_line_end = new double[NUM_OF_BOX];
		double[] y_line_end = new double[NUM_OF_BOX];

		x_line_end[GOBJECT] = 0;
		y_line_end[GOBJECT] = 0;
		for(int i = 1; i < NUM_OF_BOX; i++)
		{
			x_line_end[i] = x_box[i] + box_width / 2;
			y_line_end[i] = y_box[i];
		}
		
		
	
		/* Code Action */
		
		//1.Lines
		for(int i = 1; i < NUM_OF_BOX; i++){
			GObject line = new GLine(x_line_start,y_line_start,x_line_end[i],y_line_end[i]);
			add(line);
		}
		//2.box and labels
		for(int i = 0 ; i < NUM_OF_BOX; i++){
			add(box_arr[i],x_box[i],y_box[i]);
			add(label_arr[i],x_label[i],y_label[i]);
		}

	}
}

