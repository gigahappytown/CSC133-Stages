package com.csus.csc133;

public class WaterDispenser extends Facility
{
	@Override
	void handleCollide(Student stu)
	{
		if (stu instanceof StudentPlayer)
		{
		stu.drink();
		}
	}

}
