package data;

import java.util.ArrayList;
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
		/** Création des réseaux et placements dans la liste **/
		this.networks = new HashMap<>();
		this.networks.put("Network 1", new Network("192.168.1.0", "Network 1"));
		this.networks.put("Network 2", new Network("192.168.2.0", "Network 2"));
		this.networks.put("Network 3", new Network("192.168.3.0", "Network 3"));

		/** Création des locaux et placements dans la liste **/
		this.rooms = new HashMap<>();
		this.rooms.put("Room 1", new Room("Room 1", 5000));
		this.rooms.put("Room 2", new Room("Room 2", 6000));
		this.rooms.put("Room 3", new Room("Room 3", 4500));
		this.rooms.put("Room 4", new Room("Room 4", 5000));
		this.rooms.put("Room 5", new Room("Room 5", 4000));

		this.devices = new HashMap<>();
	}

	public void addDevice(Device device)
	{
		this.devices.put(Integer.valueOf(device.getId()), device);
	}

	public void delDevice(int id)
	{
		Device device = this.devices.get(id);

		// TODO disconnect net + power

		this.devices.remove(id);
	}
}
