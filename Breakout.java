/*
 * File: Breakout.java
 * -------------------
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		/*
		 * 1. set up the bricks - two method : 1. setup 2. play
		 * 		- 10 x 10
		 * 2. create the paddle
		 * 3. Create a ball and get it to bounce off the walls
		 * 4.  Checking for collisions
		 * 5. Finishing up
		 * */
		
		this.setUp();
	}
	
	private void setUp()
	{
		
		this.setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
				
		setUpBrick();
		setUpPaddle();
		setUpBall();
		
		//2. set up the movable pad and balls
		
		
		//3. balls get it to bounce off the walls 
		
	}
	
	private void setUpBrick()
	{
		Color[] brick_color = {Color.red,Color.red,Color.orange,Color.orange,
				Color.yellow,Color.yellow,Color.green,Color.green,Color.cyan,
				Color.cyan};
		
		for(int height = 0; height < 10; height++)
		{
			for(int width = 0; width < 10; width++)
			{
				GObject brick = new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				brick.setColor(brick_color[height]);
				this.add(brick, width*BRICK_WIDTH, height*BRICK_HEIGHT);
			}
		}

	}
	
	private void setUpPaddle()
	{
		GObject paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		MouseListener listner = new MouseListener();

		//paddle.addMouseMotionListener();
		
		add(paddle);
	}
	private void setUpBall()
	{
		
	}


}
