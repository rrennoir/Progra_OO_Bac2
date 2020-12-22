package ui.menu;

import ui.ManagerAction;
import ui.MenuAction;

public class NetworkMenu extends Menu
{
	public NetworkMenu()
	{
		this.addItem("1 - List networks", ManagerAction.LIST_NETWORKS);
		this.addItem("2 - Show network", ManagerAction.SHOW_NETWORK);
		this.addItem("M - Main menu", MenuAction.MAIN_MENU);
	}
}
