package com.csus.csc133;

public class StudentCar extends Student
{

	public StudentCar()
	{
		setSpeed(DEFAULT_SPEED * 5);
		setSweatingRate(0);
		
		//round to 90 or 270
		//expensive operation (maybe more efficient way to do this) at least it is only done once
		if (getHeadDirection() % 360 != 90 || getHeadDirection() % 360 != 270)
		{
			double headTemp = getHeadDirection() % 360;
			if (headTemp < 180)
			{
				setHeadDirection(90);
			}
			else
			{
				setHeadDirection(270);
			}
		}
	}

}
