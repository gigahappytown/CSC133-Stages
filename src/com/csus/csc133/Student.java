package com.csus.csc133;

public abstract class Student extends GameObject implements IMoveable
{
	//changing these default values will change the default for ALL student child classes (future flexibility)
	protected static final float DEFAULT_SPEED = 200.0f; 
	protected static final float DEFAULT_TALKATIVE_LEVEL = 2.0f;
	protected static final int DEFAULT_HYDRATION = 200;
	protected static final float DEFAULT_SWEATING_RATE = 3.0f;
	
	private float headDirection;
	private float speed = DEFAULT_SPEED;
	private float talkativeLevel = DEFAULT_TALKATIVE_LEVEL;
	private float hydration = DEFAULT_HYDRATION;
	private float sweatingRate = DEFAULT_SWEATING_RATE;
	private float waterIntake = 0;
	private float timeRemain = 0;
	private float absenceTime = 0;
	
	
	//DEFAULT STUDENT CONSTRUCTOR
	
	public Student() 
	{
	//generate random position in world (x,y)
	super();
	//generate random direction between 0 to 359 for head
	//0 = north : 90 = east : 180 = south : 270 = west
	setHeadDirection(rand.nextFloat()*359);
	}
	
	//COLLISION
	@Override
	void handleCollide(Student stu)
	{
		setTimeRemain(this.talkativeLevel);
		stu.setTimeRemain(stu.talkativeLevel);
	}
	
	//FACILITY COLLISION METHODS
	
	public void drink() 
	{
		//current water intake - change in hydration
		
		setWaterIntake(getWaterIntake() +(DEFAULT_HYDRATION - getHydration()));
		//this.waterIntake = waterIntake + (DEFAULT_HYDRATION - this.hydration);
		setHydration(DEFAULT_HYDRATION);
	}
	
	public void useRestroom()
	{
		setWaterIntake(0);
	}
	
	//INTERFACE METHODS (MOVEMENT)
	
	public void sweat() 
	{
		setHydration(getHydration() - getSweatingRate());
	}
	
	//call method per each frame (f)
	public void move()
	{
		//precondition to move (not talking)
		if (getTimeRemain() > 0)
		{
			timeRemain -= 1;
			return;
		}
		setTimeRemain(0);
		
		//sweat (hydration - sweatingrate)
		sweat();
		//move
		
		//x = x + cos(90.0-head)*speed
		//setX(getX(x) + Math.sin((headDirection + -90.0)) * speed);
		//cos isolates change in x
		//sin isolates change in y
		
		double rad = Math.toRadians((90.0 - headDirection));
		
		setX(getX() + (Math.cos(rad) * getSpeed())); 
		setY(getY() + (Math.sin(rad) * getSpeed()));
		
		//bounds checking
		if (getX() > X_AXIS_LIMIT || getX() < 0 || getY() > Y_AXIS_LIMIT || getY() < 0)
		{
			setHeadDirection((this.headDirection + 180) % 360);
		}
		//violate x
		if (getX() > X_AXIS_LIMIT || getX() < 0)
		{	
			if (getX() > X_AXIS_LIMIT)
			{
				setX(1024);	
			} 
			else
			{
				setX(0);
			}
		}
		//violate y
		if (getY() > Y_AXIS_LIMIT || getY() < 0)
		{
			
			if (getY() > Y_AXIS_LIMIT)
			{
				setY(768);	
			} 
			else
			{
				setY(0);
			}
		}
	} 
	
	//PRINT
	void printInfo()
	{
		printBasic();
		printStudent();
		System.out.println();
	}
	
	void printStudent()
	{
		System.out.print("\thead:" + round(getHeadDirection()));
		System.out.print(",\tspeed: " + round(getSpeed()));
		System.out.print(",\thydration: " + round(getHydration()));
		System.out.print(",\ttalkativeLevel: " + round(getTalkativeLevel()));
		System.out.print(",\ttimeRemain: " + round(getTimeRemain()));
	}
	
	
	//GET AND SET METHODS
	
	//headDirection
	public float getHeadDirection()
	{
		return headDirection;
	}
	public void setHeadDirection(float headDirection)
	{
		this.headDirection = headDirection;
	}
	
	//speed
	public float getSpeed()
	{
		return speed;
	}
	public void setSpeed(float speed)
	{
		this.speed = speed;
	}
	
	//talkativeLevel
	public float getTalkativeLevel()
	{
		return talkativeLevel;
	}
	public void setTalkativeLevel(float talkativeLevel)
	{
		this.talkativeLevel = talkativeLevel;
	}
	
	//timeRemain
	public float getTimeRemain()
	{
		return timeRemain;
	}
	public void setTimeRemain(float timeRemain)
	{
		this.timeRemain = timeRemain;
	}
	
	//hydration
	public float getHydration()
	{
		return hydration;
	}
	public void setHydration(float hydration)
	{
		this.hydration = hydration;
	}
	
	//waterIntake (drink) //STUDENT PLAYER CLASS METHOD
	public float getWaterIntake()
	{
		return waterIntake;
	}
	public void setWaterIntake(float waterIntake)
	{
		this.waterIntake = waterIntake;
	}
	
	//sweatingRate
	public float getSweatingRate()
	{
		return sweatingRate;
	}
	public void setSweatingRate(float sweatingRate)
	{
		this.sweatingRate = sweatingRate;
	}
	
	//abscenseTime
	public float getAbsenceTime()
	{
		return absenceTime;
	}
	
	public void setabsenceTime(float absenceTime)
	{
		this.absenceTime = absenceTime;
	}

	
}
