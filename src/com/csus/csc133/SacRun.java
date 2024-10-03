package com.csus.csc133;

import com.codename1.ui.*;
import com.codename1.ui.events.*;

public class SacRun extends Form
{
	
	private GameModel gm;
	
	public SacRun()
	{
		gm = new GameModel();
		
		//call method to initialize objects
		gm.init();
		
		//this starts game
		A1();
		
	}
	
	//UI provided for A1 only, remove it in A2
	private void A1() 
	{
		Label myLabel=new Label("Enter a Command:");
		TextField myTextField=new TextField();
		this.add(myLabel).add(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.isEmpty()) return;
				handleInput(sCommand.charAt(0));
			}
		});
	}

	private void handleInput(char key) 
	{
		switch (key)
		{
		//player move
			case 'w':
				gm.start();
				break;
			case 's':
				gm.stop();
				break;
			case 'a':
				gm.turnLeft();
				break;
			case 'd':
				gm.turnRight();
				break;
		
		//collision
			case '1':
				gm.collideLectureHall();
				break;
			case '2':
				gm.collideRestroom();
				break;
			case '3': 
				gm.collideWaterDispenser();
				break;
			case '4':
				gm.collideStudent();
				break;
				
		//frame
			case 'f':
				gm.nextFrame();
				break;
				
		//game data
			case 'm':
				gm.outputInformation();
				break;
				
		//signature :)
			case 'i':
				gm.printName();
				break;
				
		//invalid char error (default case)
			default:
				System.out.println("Error: Invalid char");
		}
	}
		
}
