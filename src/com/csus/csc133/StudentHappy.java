package com.csus.csc133;

public class StudentHappy extends Student
{
	//set speed to 10x original, move, then set speed to default
	@Override
	public void move()
	{
		setSpeed(DEFAULT_SPEED * 10);
		super.move();
		setSpeed(DEFAULT_SPEED);
	}

}
