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
		this.netList.add(new Network("192.168.1.0", "Network 1"));
		this.netList.add(new Network("192.168.2.0", "Network 2"));
		this.netList.add(new Network("192.168.3.0", "Network 3"));
	
		/** Création des locaux et placements dans la liste **/
		this.roomList = new ArrayList<Room>();
		this.roomList.add(new Room("Room 1", 5000));
		this.roomList.add(new Room("Room 2", 6000));
		this.roomList.add(new Room("Room 3", 4500));
		this.roomList.add(new Room("Room 4", 5000));
		this.roomList.add(new Room("Room 5", 4000));

		this.pcList = new ArrayList<Pc>();
		this.phoneList = new ArrayList<Phone>();
		this.printerList = new ArrayList<Printer>();
	}

	public void addPc(Pc newPc)
	{
		this.pcList.add(newPc);
	}

	public void addPhone(Phone newPhone)
	{
		this.phoneList.add(newPhone);
	}

	public void addPrinter(Printer newPrinter)
	{
		this.printerList.add(newPrinter);
	}

	public void delDevice(int id)
	{
		// TODO disconnect network + room too
		int index = -1;
		for (Pc pc : this.pcList)
			if (pc.getId() == id)
				index = this.pcList.indexOf(pc);
		
		if (index != -1)
			this.pcList.remove(index);

		index = -1;
		for (Phone phone : this.phoneList)
			if (phone.getId() == id)
				index = this.phoneList.indexOf(phone);

		if (index != -1)
			this.phoneList.remove(index);

		index = -1;
		for (Printer printer : this.printerList)
			if (printer.getId() == id)
				index = this.printerList.indexOf(printer);

		if (index != -1)
			this.printerList.remove(index);
	}
}
