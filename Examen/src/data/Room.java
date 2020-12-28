package data;

import java.util.ArrayList;

public class Room 
{
	private String name;
	private int powerSupp;
	private ArrayList<Device> roomList;
	
	/*Constructeur*/
	Room(String name, int powerSupp)
	{
		this.name = name;
		this.powerSupp = powerSupp;
		this.roomList = new ArrayList<Device>();
	}
	
	/*Update powerSupp*/
	private void PowerUse() 
	{
		for (Device dev : roomList) 
		{
		this.powerSupp -= dev.powerGive();
		}
	}
	
	public void Switcher() 
	{
		for (Device dev : roomList)	
		{
			dev.switchPower(false);
		}
	}
	public String toString()
	{
		return "Le "+ this.name + " dispose de "+ this.powerSupp +" watts actuellement \n";
	}
}
