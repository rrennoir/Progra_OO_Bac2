package manager;

import java.util.HashMap;
import java.util.Map;

import data.Data;
import data.Network;
import data.Os;
import data.Pc;
import data.Phone;
import data.Printer;
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
		for (Pc pc : data.pcList)
		{
			System.out.println(pc);
		}

		for (Phone phone : data.phoneList)
		{
			System.out.println(phone);
		}

		for (Printer printer : data.printerList)
		{
			System.out.println(printer);
		}
	}

	private void showDevice(UI ui, Data data)
	{
		System.out.print("Select device ID");
		String choice = UI.scanner.next();

		boolean found = false;

		for (Pc pc : data.pcList)
		{
			if (!found && pc.getId() == Integer.parseInt(choice))
				found = true;
				System.out.println(pc);
		}

		for (Phone phone : data.phoneList)
		{
			if (!found && phone.getId() == Integer.parseInt(choice))
				found = true;
				System.out.println(phone);
		}

		for (Printer printer : data.printerList)
		{
			if (!found && printer.getId() == Integer.parseInt(choice))
				found = true;
				System.out.println(printer);
		}
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

		boolean found = false;
		String locationName = "";
		Room location = data.roomList.get(0);
		while (!found)
		{
			System.out.print("Location: ");
			locationName = UI.scanner.nextLine();
			for (Room room : data.roomList)
			{
				if (locationName.equals(room.getName()))
				{
					location = room;
					found = true;
				}
			}
		}

		found = false;
		String networkName = "";
		Network network = data.netList.get(0);
		while (!found)
		{
			System.out.print("Network: ");
			networkName = UI.scanner.nextLine();
			for (Network net : data.netList)
			{
				if (networkName.equals(net.getName()))
				{
					network = net;
					found = true;
				}
			}
		}

		if (type.equals("phone"))
		{
			System.out.print("Phone number: ");
			String number = UI.scanner.next();

			try
			{
				data.addPhone(new data.Phone(brand, model, serialNumber, power, number, location, network));
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
				data.addPrinter(new data.Printer(brand, model, serialNumber, power, location, network));
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
				data.addPc(new data.Pc(brand, model, serialNumber, power, os, ram, location, network));
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
		// TODO
	}

	private void listNetworks(UI ui, Data data)
	{
		for (Network net:data.netList)
		{
			System.out.println(net);
		}
	}

	private void showNetwork(UI ui, Data data)
	{
		// TODO
	}

	private void listRooms(UI ui, Data data)
	{
		for (Room rom:data.roomList)
		{
			System.out.println(rom);
		}
	}

	private void showRoom(UI ui, Data data)
	{
		// TODO
	}
}
