package ui.menu;

import java.util.HashMap;
import java.util.Map;

import ui.Action;
import ui.menu.exception.ActionNotFound;

/*
 * A menu of the UI, a list of possible actions proposed to the user
 * 
 * To create a new menu :
 * 1) Define all the actions this menu will contain
 * 2) Create a new subclass of Menu
 * 3) In the new menu constructor, add all menu items it will contain
 */
public abstract class Menu
{
	Map<String, MenuItem> items = new HashMap<>();

	public void display()
	{
		System.out.println();
		for (MenuItem item : this.items.values())
			System.out.println(item.getMenuString());
		this.prompt();
	}

	private void prompt()
	{
		System.out.print("Enter your choice : ");
	}

	public Action getAction(String choice) throws ActionNotFound
	{		
		MenuItem item = this.items.get(choice);
		
		if (item == null)
			throw new ActionNotFound("Wrong command : " + choice);

		return item.getAction();
	}

	protected void addItem(String menuString, Action action)
	{
		MenuItem item = new MenuItem(menuString, action);
		this.items.put(item.getChoiceString(), item);
	}
}
