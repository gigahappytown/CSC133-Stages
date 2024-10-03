package com.csus.csc133;

public class StudentConfused extends Student
{
	@Override
	public void move()
	{
		setHeadDirection(rand.nextFloat()*359);
		super.move();
	}
}
