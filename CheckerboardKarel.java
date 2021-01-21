/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	//how to 
		//1. Check board size 
		//2. put beepers according to board size
	
	public void run()
	{
		int row = -1, col = -1;
		//1.check board size
		row = checkRowSize();
		col = checkColSize();
		
		//2.put beepers 		
		makeCheckerBoard(row, col);
	}
	
	
	
	
	
	public void makeCheckerBoard(int row, int col)
	{
		
		// beeper position : row - even, col - odd / row - odd, col - even
		for(int beeper_row = 1; beeper_row <= row; beeper_row++)
		{
			if(beeper_row % 2 == 1)
			{
				for(int beeper_col = 1; beeper_col <= col; beeper_col++)
				{
					if(beeper_col % 2 == 1)
					{
						putBeeper();
					}
					if(!frontIsBlocked())	
						move();
				}
				
				
				moveUp();

			}
			else
			{
				for(int beeper_col = 1; beeper_col <= col; beeper_col++)
				{
					if(beeper_col % 2 == 0)
					{
						putBeeper();
					}
					if(!frontIsBlocked())	
						move();
				}
				moveUp();
			}
		}

	}
	public int checkColSize()
	{
		int count = 1; 
		
		while(!frontIsBlocked())
		{
			move();
			count++;
		}
		
		turnAround();
		while(!frontIsBlocked())
		{
			move();
		}
		turnAround();
		
		return count;
	}
	public int checkRowSize()
	{
		int count = 1; 
		
		turnLeft();
		while(!frontIsBlocked())
		{
			move();
			count++;
		}
		
		turnAround();
		while(!frontIsBlocked())
		{
			move();
		}

		turnLeft();
		
		return count;
	}
	
	public void moveUp()
	{
		turnLeft();
		if(!frontIsBlocked())	
			move();
		turnLeft();

		while(!frontIsBlocked())
			move();
		turnAround();
	}


}
