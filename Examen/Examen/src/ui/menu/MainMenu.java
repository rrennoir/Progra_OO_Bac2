package ui.menu;

import ui.ControlAction;
import ui.MenuAction;

public class MainMenu extends Menu
{
	public MainMenu()
	{
		this.addItem("1 - Manage devices", MenuAction.DEVICE_MENU);
		this.addItem("2 - Manage networks", MenuAction.NETWORK_MENU);
		this.addItem("3 - Manage rooms", MenuAction.ROOM_MENU);
		this.addItem("X - Exit program", ControlAction.EXIT);
	}
}
