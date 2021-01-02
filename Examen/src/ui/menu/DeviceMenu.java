package ui.menu;

import ui.ManagerAction;
import ui.MenuAction;

public class DeviceMenu extends Menu
{
	public DeviceMenu()
	{
		this.addItem("1 - List devices", ManagerAction.LIST_DEVICES);
		this.addItem("2 - Show device", ManagerAction.SHOW_DEVICE);
		this.addItem("3 - Add device", ManagerAction.ADD_DEVICE);
		this.addItem("4 - Delete device", ManagerAction.DELETE_DEVICE);
		this.addItem("5 - Edit device", MenuAction.EDIT_DEVICE_MENU);
		this.addItem("6 - Interact with device", MenuAction.DEVICE_INTERACT_MENU);
		this.addItem("M - Main menu", MenuAction.MAIN_MENU);
	}
}
