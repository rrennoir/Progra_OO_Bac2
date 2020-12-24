package ui.menu;

import ui.ManagerAction;
import ui.MenuAction;

public class RoomMenu extends Menu
{
	public RoomMenu()
	{
		this.addItem("1 - List rooms", ManagerAction.LIST_ROOMS);
		this.addItem("2 - Show room", ManagerAction.SHOW_ROOM);
		this.addItem("M - Main menu", MenuAction.MAIN_MENU);
	}
}
