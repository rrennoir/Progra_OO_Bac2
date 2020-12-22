package manager;

import java.util.HashMap;
import java.util.Map;

import data.Data;
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
		// TODO
	}

	private void showDevice(UI ui, Data data)
	{
		// TODO
	}

	private void addDevice(UI ui, Data data)
	{
		// TODO
	}

	private void deleteDevice(UI ui, Data data)
	{
		// TODO
	}

	private void editDevice(UI ui, Data data)
	{
		// TODO
	}

	private void listNetworks(UI ui, Data data)
	{
		// TODO
	}

	private void showNetwork(UI ui, Data data)
	{
		// TODO
	}

	private void listRooms(UI ui, Data data)
	{
		// TODO
	}

	private void showRoom(UI ui, Data data)
	{
		// TODO
	}
}
