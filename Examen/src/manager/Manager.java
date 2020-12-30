package manager;

import java.util.HashMap;
import java.util.Map;

import data.Data;
import data.Device;
import data.Network;
import data.Os;
import data.Room;
import manager.exception.ManagerMethodNotFound;
import ui.Action;
import ui.ManagerAction;
import ui.UI;

/*
 * Use this object and its methods to perform actions with the UI and Data
 */
public class Manager
{
	Map<ManagerAction, ActionMethod> actionMethods = new HashMap<>();
	
	public Manager()
	{		
		this.actionMethods.put(ManagerAction.LIST_DEVICES, this::listDevices);
		this.actionMethods.put(ManagerAction.SHOW_DEVICE, this::showDevice);
		this.actionMethods.put(ManagerAction.ADD_DEVICE, this::addDevice);
		this.actionMethods.put(ManagerAction.DELETE_DEVICE, this::deleteDevice);
		this.actionMethods.put(ManagerAction.EDIT_DEVICE, this::editDevice);

		this.actionMethods.put(ManagerAction.LIST_NETWORKS, this::listNetworks);
		this.actionMethods.put(ManagerAction.SHOW_NETWORK, this::showNetwork);

		this.actionMethods.put(ManagerAction.LIST_ROOMS, this::listRooms);
		this.actionMethods.put(ManagerAction.SHOW_ROOM, this::showRoom);
		
		/*
		 * To add more functionalities to the manager :
		 * 1) Define a new action in ManagerAction
		 * 2) Define and implement a new method in this class
		 * 3) Put the action and the corresponding method in the map here
		 */
	}

	public ActionMethod getActionMethod(Action action) throws ManagerMethodNotFound
	{
		ActionMethod actionMethod = this.actionMethods.get(action);
		if (actionMethod == null)
			throw new ManagerMethodNotFound("Manager could not find a method associated with " + action.name());
		
		return actionMethod;
	}

	private void listDevices(UI ui, Data data)
	{
		for (Map.Entry<Integer, Device> entry : data.devices.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}

	private void showDevice(UI ui, Data data)
	{
		System.out.print("Select device ID: ");
		int id = UI.scanner.nextInt();

		if (data.devices.containsKey(id))
			System.out.println(data.devices.get(id));

		else
			System.out.println(String.format("No Device with id '%d' found.", id));
	}

	private void addDevice(UI ui, Data data)
	{
		System.out.print("Type (PC/Phone/Printer): ");
		String type = UI.scanner.next().toLowerCase();

		System.out.print("Brand: ");
		String brand = UI.scanner.next();

		System.out.print("Model: ");
		String model = UI.scanner.next();

		System.out.print("Serial Number: ");
		String serialNumber = UI.scanner.next();

		System.out.print("Power: ");
		int power = UI.scanner.nextInt();

		System.out.print("Location: ");
		String locationName = UI.scanner.next();
		while (!data.rooms.containsKey(locationName))
		{
			System.out.print("Location: ");
			locationName = UI.scanner.next();
		}
		Room location = data.rooms.get(locationName);

		System.out.print("Network: ");
		String networkName = UI.scanner.next();
		while (!data.networks.containsKey(networkName))
		{
			System.out.print("Network: ");
			networkName = UI.scanner.next();
		}
		Network network = data.networks.get(networkName);

		if (type.equals("phone"))
		{
			System.out.print("Phone number: ");
			String number = UI.scanner.next();

			try
			{
				data.addDevice(new data.Phone(brand, model, serialNumber, power, number, location, network));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}

		else if (type.equals("printer"))
		{
			try
			{
				data.addDevice(new data.Printer(brand, model, serialNumber, power, location, network));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			Os os;
			System.out.print("OS (Linux / Windows): ");
			String osString = UI.scanner.next();
			if (osString.toLowerCase().equals("windows"))
				os = Os.Linux;

			else
				os = Os.Windows;

			System.out.print("Ram: ");
			int ram = Integer.parseInt(UI.scanner.next());

			try
			{	
				data.addDevice(new data.Pc(brand, model, serialNumber, power, os, ram, location, network));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	private void deleteDevice(UI ui, Data data)
	{
		System.out.print("Decice ID: ");
		int id = Integer.parseInt(UI.scanner.next());

		data.delDevice(id);
	}

	private void editDevice(UI ui, Data data)
	{
		// System.out.print("Decice ID: ");
		// int id = Integer.parseInt(UI.scanner.next());

		// Device deviceEdit = null;
		// for (Device device : data.devices)
		// 	if (device.getId() == id)
		// 		deviceEdit = device;

		// if (deviceEdit != null)
		// {

		// 	if (deviceEdit instanceof Printer)


		// 	else if (deviceEdit instanceof Phone)
		// }
				
	}

	private void listNetworks(UI ui, Data data)
	{
		for (Map.Entry<String, Network> entry : data.networks.entrySet())
		{
			System.out.println(entry.getValue());	
		}
	}

	private void showNetwork(UI ui, Data data)
	{
		System.out.print("Select Network: ");
		String name = UI.scanner.nextLine();

		if (data.networks.containsKey(name))
			System.out.println(data.networks.get(name));

		else
			System.out.println(String.format("No Network with name '%s' found.", name));
	}

	private void listRooms(UI ui, Data data)
	{
		for (Map.Entry<String, Room> entry : data.rooms.entrySet())
		{
			System.out.println(entry.getValue());	
		}
	}

	private void showRoom(UI ui, Data data)
	{
		// TODO
	}
}
