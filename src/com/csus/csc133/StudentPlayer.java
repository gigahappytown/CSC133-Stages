package com.csus.csc133;

public class StudentPlayer extends Student
{
	private boolean gameOver;
	
	public StudentPlayer()
	{
		//super call is not strictly necessary (implied)
		super(); 
		gameOver = false;
		setSpeed(0);
		//setSweatingRate(70); edge case testing
	}
	
	@Override
	public void printInfo()
	{
		printBasic();
		printStudent();
		System.out.print(",\tabsence: " + round(getAbsenceTime()));
		System.out.print(",\twaterIntake: " + round(getWaterIntake()));
		System.out.println();
	}
	
	@Override
	public void move()
	{
		super.move();
		updateGameOver();
	}

	//move methods
	
	protected void start()
	{
		setSpeed(DEFAULT_SPEED);
	}
	
	protected void stop()
	{
		setSpeed(0);
	}
	
	protected void turnLeft()
	{
		setHeadDirection(getHeadDirection() -5);
	}
	
	protected void turnRight()
	{
		setHeadDirection(getHeadDirection() + 5);
	}
	
	//Collision cases
	
	public void increaseAbsence()
	{
		this.setabsenceTime(getAbsenceTime() + 1);
	}
	
	private void updateGameOver()
	{
		if (getAbsenceTime() > 3 || getWaterIntake() > 100 || getHydration() <= 0)
		{
			setGameOver(true);
		}
	}
	
	//set and get
	
	private void setGameOver(boolean b)
	{
		this.gameOver = b;
	}
	
	public boolean getGameOver()
	{
		return this.gameOver;
	}
	
}
