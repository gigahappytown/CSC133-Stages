package com.csus.csc133;

public class Restroom extends Facility
{
	@Override
	void handleCollide(Student stu)
	{
		stu.useRestroom();
	}
}