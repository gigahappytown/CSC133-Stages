package com.csus.csc133;

import java.util.Random;

public class LectureHall extends Facility 
{
	private String nameHall;
	private boolean isLecture = false;
	Lecture lec;
	
	Random rand = new Random();
	
	//Constructor for LectureHall, accepts a Lecture Object
	LectureHall()
	{
		setName("Tahoe " + rand.nextInt(10));
	}
	
	@Override
	void printInfo()
	{
		printBasic();
		System.out.print("\thallName: " + getName());
		if (isLecture == true)
		{
			System.out.print("\tlecture: " + lec.getTime());
		}
		else
		{
			System.out.print(",\tlecture: null");
		}
		System.out.println();
	}
	
	void handleCollide(Student stu)
	{
		if (stu instanceof StudentPlayer)
		{ 
			//if active lecture
			//end lecture immediately
			if (isLecture == true)
			{
				setIsLecture(false);
			}
		}
	}
	
	public void startLecture(int i)
	{
		lec.setTime(i);		
	}
	
	//get and set
	public void setName(String name)
	{
		this.nameHall = name;
	}
	public String getName()
	{
		return this.nameHall;
	}
	
	public void setIsLecture(boolean b)
	{
		this.isLecture = b;
	}
	
	public boolean getIsLecture()
	{
		return this.isLecture;
	}
	
}
