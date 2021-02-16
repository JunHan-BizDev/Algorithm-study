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
		this.playProgram();
	}
	
	private void setUp()
	{
		
		this.setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
				
		setUpBrick();
		setUpPaddle();
		setUpBall();
		
		//2. set up the movable pad and balls
		playProgram();
		
		//3. balls get it to bounce off the walls 
		
	}
	
	private void setUpBrick()
	{
		
		for(int height = 0; height < NBRICK_ROWS; height++)
		{
			int y = BRICK_Y_OFFSET + (height * (BRICK_HEIGHT + BRICK_SEP));

			for(int width = 0; width < NBRICKS_PER_ROW; width++)
			{
				int x = (width * (BRICK_SEP + BRICK_WIDTH)) + ((WIDTH - 
						((NBRICKS_PER_ROW * BRICK_WIDTH) + ((NBRICKS_PER_ROW - 1) * BRICK_SEP))) / 2);

				GRect brick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
				brick.setColor(brick_color[height]);
				brick.setFilled(true);
				this.add(brick);
			}
		}
	}
	
	//mouse motion listener 추가해야됨
	private void setUpPaddle()
	{
		GRect paddle = new GRect( (WIDTH- PADDLE_WIDTH) / 2, HEIGHT-(PADDLE_Y_OFFSET+PADDLE_HEIGHT) ,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.addMouseMotionListener(null);
		this.addMouseListeners();
		add(paddle);
	}
	
	private void setUpBall()
	{
		ball = new GOval(WIDTH / 2 - BALL_RADIUS / 2,
				HEIGHT / 2 - BALL_RADIUS / 2,
				BALL_RADIUS, BALL_RADIUS);
		
		ball.setFillColor (Color.BLACK);
		ball.setFilled (true);
		add(ball);
		vx = rgen.nextDouble(1.0, 3.0);
		if(rgen.nextBoolean(0.5))
			vx = -vx;
		vy = 3.0;

        String message= "Click to start";
        GLabel prompt= new GLabel (message);
        prompt.setColor(Color.red);
        prompt.setFont(new Font("Arial", Font.PLAIN, 15));
        prompt.move ((WIDTH-prompt.getWidth())/2, 100/2);
        add(prompt);
        waitForClick();
        remove(prompt);

	}

	private MouseMotionListener setPaddleMovable(GObject paddle)
	{
		MouseMotionListener x_paddle = new MouseMotionListener() {
			
		
			@Override
			public void mouseMoved(MouseEvent e) {
				GPoint loc = new GPoint(e.getX(),PADDLE_Y_OFFSET);
				paddle.setLocation(loc);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		return x_paddle;
	}

	
	
	private void playProgram()
	{
		setBallMovable();
	}
	
	private void setBallMovable()
	{
		
		ball_pos = ball.getLocation();
		if(ball_pos.getX() + BALL_RADIUS > WIDTH) 
			vx = -vx;
		else if(ball_pos.getX() <= 0)
			vx = - vx;
		
		if(ball_pos.getY() >= HEIGHT)
			vy = vy;
		else if(ball_pos.getY() <= 0)
			vy = -vy;
		
		ball.move(vx, vy);
		
		checkCollision();
	}
	
	private Boolean checkCollision()
	{
		GObject check_collision;
		check_collision = this.getElementAt(vx, vy);
		
		//if(check_collision != null);
			
		return true;
	}	
	
	
	/* member variables */
	
	private double vx, vy; //keep track of the velocity of the ball
	private RandomGenerator rgen = new RandomGenerator(); //random values
	private GOval ball;
	private GPoint ball_pos;
	private static Color[] brick_color = {Color.red,Color.red,Color.orange,Color.orange,
			Color.yellow,Color.yellow,Color.green,Color.green,Color.cyan,
			Color.cyan};
	
}
