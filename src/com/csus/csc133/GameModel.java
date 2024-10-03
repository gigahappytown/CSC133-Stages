package com.csus.csc133;

import java.util.Vector;
import java.util.Random;

public class GameModel 
{
	//hardcoded world size
	//public static final int WORLD_WIDTH = 1024;
	//public static final int WORLD_HEIGHT = 768;
	
	private float gameTime = 0;
	
	//declare vector and lecture (not instantiated yet)
	private Vector<GameObject> gameObject;
	private Random r = new Random();
	
	//A1: initialize one instance per each unique object
	public void init() 
	{
		//initialize Vector
		gameObject = new Vector<>();
		
		//add Student Player first
		//access index 0 and call methods for move
		gameObject.add(new StudentPlayer());
		
		//add Student
		gameObject.add(new StudentAngry());
		gameObject.add(new StudentBiking());
		gameObject.add(new StudentCar());
		gameObject.add(new StudentConfused());
		gameObject.add(new StudentFriendly());
		gameObject.add(new StudentHappy());
		gameObject.add(new StudentNonstop());
		gameObject.add(new StudentRunning());
		gameObject.add(new StudentSleeping());
		
		//add Facility
		gameObject.add(new LectureHall());
		gameObject.add(new Restroom());
		gameObject.add(new WaterDispenser());
		
		//gameObject.add(new Student()); (duplicaiton code ctrl alt down)
		
	}
	
	// 'w' player move
	// 's' player stop
	// 'a' player left
	// 'd' player right
	
	protected void start()
	{
		//typecast to StudentPlayer then call StudentPlayer method
		((StudentPlayer) gameObject.get(0)).start();
		System.out.println("Student start moving");
	}
	
	protected void stop()
	{
		((StudentPlayer) gameObject.get(0)).stop();
		System.out.println("Student stop moving");
	}
	
	protected void turnLeft()
	{
		((StudentPlayer) gameObject.get(0)).turnLeft();
		System.out.println("Student turn left");
	}
	
	protected void turnRight()
	{
		((StudentPlayer) gameObject.get(0)).turnRight();
		System.out.println("Student turn right");
	}
	
	// StudentPlayer Collision:
	// '1' Lecture Hall
	// '2' Restroom
	// '3' WaterDispenser
	// '4' Student (other random student) 
		//SELECT RANDOM INDEX OF VECTOR (vectorLength() - 1) + 1 (shift to exclude 0)
		//If instanceof student
		//collide
	
	protected void collideLectureHall()
	{
		//loop to find index that contains proper child class
		//then type cast to run method to handle collision
		for (int i = 0; i < gameObject.size(); i++)
		{
			if (gameObject.get(i) instanceof LectureHall)
			{
				System.out.println("Attended Lecture:");
				gameObject.get(i).handleCollide((StudentPlayer) gameObject.get(0));
			}
		}
	}
	
	protected void collideRestroom()
	{
		for (int i = 0; i < gameObject.size(); i++)
		{
			if (gameObject.get(i) instanceof Restroom)
			{
				System.out.println("Used Restroom:"); //TEMP
				gameObject.get(i).handleCollide((Student) gameObject.get(0));
			}
		}
	}
	
	protected void collideWaterDispenser()
	{
		for (int i = 0; i < gameObject.size(); i++)
		{
			if (gameObject.get(i) instanceof WaterDispenser)
			{
				System.out.println("Used Water Dispenser:");// TEMP
				gameObject.get(i).handleCollide((StudentPlayer) gameObject.get(0));
			}
		}
	}
	
	protected void collideStudent()

	{
		//hardcoded solution (to be improved)
		int randomStudent = r.nextInt(gameObject.size() - 2) + 1;
		if (gameObject.get(randomStudent) instanceof Student)
		{
			System.out.println("Talking To Random Student:");
			gameObject.get(randomStudent).handleCollide((Student) gameObject.get(0));
		}
	}
	
	/*: 
	 1. Increment time
	 2. check if lecture started, if not 10% change to start a lecture and assign it to one lecturehall.
	 	if yes, decrease lecture time, if lecture time == 0 and player did not reach hall on time, lecture ends and absenceTime increments	 	
	 3. loop through all game objects and call move()
	 4. check if game is ended (StudentPlayer absent from too many lecutures, too much water intake, hydration == 0)
	 	output "Gameover. Time: time"
	*/
	
	protected void nextFrame()
	{
		System.out.println("next frame:");
		//1.
		increaseGameTime(); 
		//2.
				for (int i = 0; i < gameObject.size(); i++)
				{
					if (gameObject.get(i) instanceof LectureHall)
					{
						LectureHall hall = (LectureHall) gameObject.get(i);
						if (hall.getIsLecture() == false)
						{
							//10% chance to initialize a lecture and assign to lectureHall
							if (r.nextInt(10) < 1)
							{
								hall.setIsLecture(true);
								Lecture lec = new Lecture();
								hall.lec = lec;
								hall.startLecture(r.nextInt(10) + 5);
							}
						}
						else
						{//
							hall.lec.reduceTime();
							if (hall.lec.getTime() <= 0)
							{
								((StudentPlayer) gameObject.get(0)).increaseAbsence();
								hall.setIsLecture(false);  
							}
						}
					}
				}
		//3.
		for (int i = 0; i < gameObject.size(); i++)
		{
			if (gameObject.get(i) instanceof Student)
			{
				Student stu = (Student) gameObject.get(i);
				stu.move();
			}
		}
		//4.
		if (((StudentPlayer) gameObject.get(0)).getGameOver() == true)
		{
			System.out.println("Gameover. Time: " + getGameTime());
		}
	}
	
	protected void outputInformation()
	{
		System.out.println("Output Information:");
		System.out.println("Game Time: " + getGameTime());
		for (int i = 0; i < gameObject.size(); i++)
		{
			gameObject.get(i).printInfo();
		}
	}
	
	protected void printName()
	{
		System.out.println("Ezra Pisiw");
	}
	
	//get and set method
	
	protected void increaseGameTime()
	{
		this.gameTime = getGameTime() + 1;
	}
	
	protected float getGameTime()
	{
		return this.gameTime;
	}

}


