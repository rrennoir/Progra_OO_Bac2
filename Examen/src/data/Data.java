package data;

import java.util.HashMap;
import java.util.Map;

/*
 * Use this object (and others) to store information about the devices, networks and rooms
 */
public class Data
{
	public Map<String, Room> rooms;
	public Map<String, Network> networks;
	public Map<Integer, Device> devices;

	public Data()
	{
		/** Creation des reseaux et placements dans la liste **/
		this.networks = new HashMap<>();
		this.networks.put("Network_1", new Network("192.168.1.0","Network_1"));
		this.networks.put("Network_2", new Network("192.168.2.0","Network_2"));
		this.networks.put("Network_3", new Network("192.168.3.0","Network_3"));

		/** Creation des locaux et placements dans la liste **/
		this.rooms = new HashMap<>();
		this.rooms.put("Room_1", new Room("Room_1", 5000));
		this.rooms.put("Room_2", new Room("Room_2", 6000));
		this.rooms.put("Room_3", new Room("Room_3", 4500));
		this.rooms.put("Room_4", new Room("Room_4", 5000));
		this.rooms.put("Room_5", new Room("Room_5", 4000));

		this.devices = new HashMap<>();
	}

	public void addDevice(Device device)
	{
		this.devices.put(Integer.valueOf(device.getId()), device);
	}

	public void delDevice(int id)
	{
		if (this.devices.containsKey(id))
		{
			Device device = this.devices.get(id);
			device.delSelf();
			this.devices.remove(id);
		}
		else
			System.out.println(String.format("Device with id %s doesn't exist", id));
	}
	
	public void showNetwork(String name)
	{	
		String devDescri = "";
		for (Map.Entry<Integer, Device> entry : this.devices.entrySet())
		{
			if (entry.getValue().getNetwork().getName().equals(name))
			{
				String sglDev= entry.getValue() + " \n ";
				devDescri += sglDev;
			}
		}
		System.out.println( "Voici la liste des devices du "+ name + " : \n"+ devDescri);
	}
}
