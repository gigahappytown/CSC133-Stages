package com.csus.csc133;

public class Lecture
{
	private float time;
	//private boolean inSession = false;
	
	//constructor
	Lecture()
	{
	}
	
	public void reduceTime()
	{
		this.time = time - 1;
	}
	
	//set and get methods
	public float getTime()
	{
		return time;
	}
	public void setTime(float x)
	{
		this.time = x;
	}
	
	/*
	public boolean getInSession()
	{
		return this.inSession;
	}
	public void setInSession(boolean b)
	{
		this.inSession = b;
	}
	*/
}
