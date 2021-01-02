package data;

import java.util.ArrayList;

public class Room 
{
	private String name;
	private int roomPower;
	private int powerAvailable;
	private ArrayList<Device> roomList;
	
	/*Constructeur*/
	Room(String name, int power)
	{
		this.name = name;
		this.roomPower = power;
		this.powerAvailable = power;
		this.roomList = new ArrayList<Device>();
	}
	
	public String getName()
	{
		return this.name;
	}

	public boolean increaseLoad(int power) 
	{
		if (this.powerAvailable >= power)
		{
			this.powerAvailable -= power;
			return true;
		}
		else
			return false;
	}
	
	public void decreaseLoad(int power)
	{
		this.powerAvailable += power;
	}

	public void Switcher() 
	{
		for (Device dev : roomList)
			if (dev.isDeviceOn())
				dev.turnOff();
	}

	public String toString()
	{
		return "Le " + this.name + " dispose de " + this.roomPower + " watts et " + this.powerAvailable + " de disponibles , et " + this.roomList.size() + " appareils connectes \n";
	}
	
	public void addDevToRoom(Device dev)
	{
		this.roomList.add(dev);
	}
	
	public void delDevFromRoom(Device dev)
	{
		this.roomList.remove(dev);
	}
	
	public void showRoomDevices()
	{
		String devDescri = "";
		for (Device dev:roomList)
		{ 	
			String sglDev = dev +" \n ";
			devDescri += sglDev;
		}
		System.out.println("Voici la liste des devices du "+ this.name+ " : \n"+ devDescri);
	}
}
