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
		this.addItem("5 - Edit device", ManagerAction.EDIT_DEVICE);
		this.addItem("M - Main menu", MenuAction.MAIN_MENU);
	}
}
