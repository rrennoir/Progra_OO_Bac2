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
		this.actionMethods.put(ManagerAction.INTERACT_DEVICE, this::interactDevice);

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
			Device device = entry.getValue();

			if (device instanceof data.Pc)
				System.out.println((data.Pc)device);
			
			else if (device instanceof data.Phone)
				System.out.println((data.Phone)device);

			else if (device instanceof data.Printer)
				System.out.println((data.Printer)device);
		}
	}

	private void showDevice(UI ui, Data data)
	{
		System.out.print("Select device ID: ");

		int id = 0;
		try
		{
			id = UI.scanner.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Number please.");
		}

		if (data.devices.containsKey(id))
		{
			Device device = data.devices.get(id);

			if (device instanceof data.Pc)
				System.out.println((data.Pc)device);
		
			else if (device instanceof data.Phone)
				System.out.println((data.Phone)device);

			else if (device instanceof data.Printer)
				System.out.println((data.Printer)device);
		}
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
		int power = 100;
		try
		{
			power = UI.scanner.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Number please.");
		}

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
			if (osString.toLowerCase().equals("linux"))
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
		System.out.print("Decice ID: ");

		int id = -1;
		try
		{
			id = UI.scanner.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Number please.");
		}

		if (data.devices.containsKey(id))
		{
			Device device = data.devices.get(id);
			
			System.out.println("Editable properties: ");
			System.out.println("-Brand(ALL)\n-Model(ALL)\n-Serial_Number(ALL)\n-Power(ALL)\n-Location(ALL)\n-Network(ALL)");
			System.out.println("-OS(PC)\n-RAM(PC)\n-Phone_Number(Phone)");
			System.out.print("What property to you want to edit ? ");

			String proprety = UI.scanner.next();

			switch (proprety.toLowerCase())
			{
				case "brand":

					System.out.print("New brand: ");
					String brand = UI.scanner.next();

					try
					{
						device.setBrand(brand);
					}
					catch (Exception e)
					{
						System.out.println("Device with the same brand, model and serial number already exist");
					}
					break;

				case "model":
					
					System.out.print("New model: ");
					String model = UI.scanner.next();

					try
					{
						device.setModel(model);
					}
					catch (Exception e)
					{
						System.out.println("Device with the same brand, model and serial number already exist");
					}
					break;

				case "serial number":

					System.out.print("New serial number: ");
					String serialNumber = UI.scanner.next();

					try
					{
						device.setSerialNumber(serialNumber);
					}
					catch (Exception e)
					{
						System.out.println("Device with the same brand, model and serial number already exist");
					}
					break;

				case "power":

					System.out.print("New power: ");

					try
					{
						int power = UI.scanner.nextInt();
						device.setPower(power);
					}
					catch (Exception e)
					{
						System.out.println("Number please.");
					}

					break;

				case "location":
					
					System.out.print("New location: ");
					String locationName = UI.scanner.next();
					while (!data.rooms.containsKey(locationName))
					{
						System.out.print("New location: ");
						locationName = UI.scanner.next();
					}
					Room newLocation = data.rooms.get(locationName);
					device.setLocation(newLocation);

					break;
			
				case "network":

					System.out.print("New network: ");
					String networkName = UI.scanner.next();
					while (!data.networks.containsKey(networkName))
					{
						System.out.print("New network: ");
						networkName = UI.scanner.next();
					}
					Network newNetwork = data.networks.get(networkName);
					device.setNetwork(newNetwork);

					break;
				
				case "os":
					
					if (device instanceof data.Pc)
					{
						data.Pc pc = (data.Pc)device;
						System.out.print("new os (Linux / Windows): ");
						String osName = UI.scanner.next();
	
						Os os;
						if (osName.toLowerCase().equals("linux"))
							os = Os.Linux;
			
						else
							os = Os.Windows;
	
						pc.setOs(os);
					}
					else
						System.out.println("Only pc device have an os properties.");

					break;

				case "ram":
					
					if (device instanceof data.Pc)
					{
						data.Pc pc = (data.Pc)device;
						System.out.print("new ram: ");

						int ram = 1024;
						try
						{
							ram = UI.scanner.nextInt();
						}
						catch (Exception e)
						{
							System.out.println("Number please.");
						}

						pc.setRam(ram);
					}
					else
						System.out.println("Only pc device have a ram properties.");
					
					break;
				
				case "phone_number":
					
					if (device instanceof data.Phone)
					{
						data.Phone phone = (data.Phone)device;
						System.out.print("new number: ");
						String number = UI.scanner.next();

						phone.setNumber(number);
					}
					else
						System.out.println("Only phone device have a phone_number properties.");
					
					break;

				default:
					System.out.println("Only phone device have a phone_number properties.");
					break;
			}
		}
		else
			System.out.println("ID doesn't exist");
	}

	private void interactDevice(UI ui, Data data)
	{
		System.out.print("Decice ID: ");

		int id = 0;
		try
		{
			id = UI.scanner.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Number please.");
		}
		Device device = data.devices.get(id);
			
		System.out.println("Possible Action: ");
		System.out.println("-TurnOn(ALL)\n-TurnOff(ALL)\n-Ring(Phone)\n-Print(Printer)\n-AddPaper(Printer)");
		System.out.print("What action to you want to do ? ");

		String action = UI.scanner.next();

		switch (action.toLowerCase())
		{
			case "turnon":

				if (device instanceof data.Pc)
				{
					data.Pc pc = (data.Pc)device;
					pc.turnOn();
				}
				else if (device instanceof data.Phone)
				{
					data.Phone phone = (data.Phone)device;
					phone.turnOn();
				}
				else if (device instanceof data.Printer)
				{
					data.Printer printer = (data.Printer)device;
					printer.turnOn();
				}

				break;
		
			case "turnoff":

				if (device instanceof data.Pc)
				{
					data.Pc pc = (data.Pc)device;
					pc.turnOff();
				}
				else if (device instanceof data.Phone)
				{
					data.Phone phone = (data.Phone)device;
					phone.turnOff();
				}
				else if (device instanceof data.Printer)
				{
					data.Printer printer = (data.Printer)device;
					printer.turnOff();
				}
				
				break;
			
			case "ring":

				if (device instanceof data.Phone)
				{
					data.Phone phone = (data.Phone)device;
					phone.ring();
				}
				else
					System.out.println("Ring action is only for Phone devices");

				break;

			case "print":

				if (device instanceof data.Printer)
				{
					data.Printer printer = (data.Printer)device;

					String thxJava = UI.scanner.nextLine(); // remove \n from previous scanner.next() because java ...
					System.out.println("Text to print: ");
					String textToPrint = UI.scanner.nextLine();
					printer.print(textToPrint);
				}
				else
					System.out.println("Print action is only for Printer devices");

				break;

			case "addpaper":

				if (device instanceof data.Printer)
				{
					data.Printer printer = (data.Printer)device;
		
					System.out.println("Paper to add: ");
					int paperToAdd = 0;
					try
					{
						paperToAdd = UI.scanner.nextInt();
					}
					catch (Exception e)
					{
						System.out.println("Number please.");
					}
					printer.addPaper(paperToAdd);
				}
				else
				System.out.println("Ring action is only for Phone devices");

				break;

			default:

				System.out.println("Invalide action");
	
				break;
		}
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
		String name = UI.scanner.next();

		data.showNetwork(name);
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
		System.out.print("Select Room: ");
		String name = UI.scanner.next();
		while (!data.rooms.containsKey(name))
		{
			System.out.print("Select Room: ");
			name = UI.scanner.next();
		}	
		Room room = data.rooms.get(name);
		System.out.println(room);
		room.showRoomDevices();	
	}
}
