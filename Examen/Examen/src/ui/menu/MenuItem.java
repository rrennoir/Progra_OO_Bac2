package ui.menu;

import ui.Action;

public class MenuItem
{
	private String menuString;

	private Action action;

	public MenuItem(String menuString, Action action)
	{
		this.menuString = menuString;
		this.action = action;
	}

	public Action getAction()
	{
		return this.action;
	}

	public String getMenuString()
	{
		return this.menuString;
	}

	public String getChoiceString()
	{
		return this.getMenuString().split(" ")[0];
	}
}
