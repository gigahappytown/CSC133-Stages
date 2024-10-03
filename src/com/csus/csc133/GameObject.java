package com.csus.csc133;

import java.util.Random;
import java.lang.Math;


public abstract class GameObject
{
	public static final int X_AXIS_LIMIT = 1024;
	public static final int Y_AXIS_LIMIT = 768;
	
	protected double x,y;
	
	//one instance of random for entire package
	public Random rand = new Random();
	
	//constructor
	public GameObject()
	{
		//TEMP this will be a functionality of individual classes (passed arguments)
		//set a random coordinate between [0,Limit]
		this.x = rand.nextInt(X_AXIS_LIMIT);
		this.y = rand.nextInt(Y_AXIS_LIMIT);
	}
	
	//abstract methods
	abstract void handleCollide(Student stu);
	
	abstract void printInfo();
	
	protected static double round (double value)
	{
		return (double)  Math.round(value * 10) /10;
	}
	//method overloading
	protected static float round (float value)
	{
		return (float)  Math.round(value * 10) /10;
	}
	
	protected void printBasic()
	{
		System.out.print(getClass().getSimpleName());
		System.out.print("\tpos: (" + round(getX()) + ", " + round(getY()) + ")");
	}
	
	
	//get and set (concrete)
	public double getX()
	{
		return x;
	}
	public void setX(double x)
	{
		this.x = x;
	}
	public double getY()
	{
		return y;
	}
	public void setY(double y)
	{
		this.y = y;
	}
	
}
