package data;

import java.util.ArrayList;

/*
 * Use this object (and others) to store information about the devices, networks and rooms
 */
public class Data
{
	public ArrayList<Room> roomList;
	public ArrayList<Network> netList;
	public ArrayList<Phone> phoneList;
	public ArrayList<Pc> pcList;
	public ArrayList<Printer> printerList;

	public Data()
	{
		/** Création des réseaux et placements dans la liste **/
		this.netList = new ArrayList<Network>();
		this.netList.add(new Network("192.168.1.0", "Réseau 1"));
		this.netList.add(new Network("192.168.2.0", "Réseau 2"));
		this.netList.add(new Network("192.168.3.0", "Réseau 3"));
	
		/** Création des locaux et placements dans la liste **/
		this.roomList = new ArrayList<Room>();
		this.roomList.add(new Room("Local 1 ", 5000));
		this.roomList.add(new Room("Local 2 ", 6000));
		this.roomList.add(new Room("Local 3 ", 4500));
		this.roomList.add(new Room("Local 4 ", 5000));
		this.roomList.add(new Room("Local 5 ", 4000));

		this.pcList = new ArrayList<Pc>();
		this.phoneList = new ArrayList<Phone>();
		this.printerList = new ArrayList<Printer>();

		try
		{
			// TEST DEVICES
			Phone p1 = new Phone("a", "h", "23", 5, "123456789", this.roomList.get(1), netList.get(0));
			Phone p2 = new Phone("b", "f", "1", 5, "123444789", this.roomList.get(2), netList.get(0));
			Pc pc1 = new Pc("d", "j", "25", 5, Os.Windows, 1024, this.roomList.get(1), netList.get(1));
			Pc pc2 = new Pc("d", "i", "1", 5, Os.Linux, 123548, this.roomList.get(0), netList.get(1));
			Printer pt1 = new Printer("c", "h", "25", 5, this.roomList.get(2), netList.get(2));
			Printer pt2 = new Printer("f", "g", "54", 5, this.roomList.get(1), netList.get(2));
			this.phoneList.add(p1);
			this.phoneList.add(p2);
			this.pcList.add(pc1);
			this.pcList.add(pc2);
			this.printerList.add(pt1);
			this.printerList.add(pt2);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
