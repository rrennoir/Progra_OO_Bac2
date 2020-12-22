package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ui.menu.DeviceMenu;
import ui.menu.MainMenu;
import ui.menu.Menu;
import ui.menu.NetworkMenu;
import ui.menu.RoomMenu;
import ui.menu.exception.ActionNotFound;
import ui.menu.exception.MenuNotFound;

/*
 * Use this object to display and get information from the user
 */
public class UI
{
	// Scanner on stdin, use it to read input from the user
	public static final Scanner scanner = new Scanner(System.in);

	private Menu currentMenu;

	private Map<Action, Menu> menus = new HashMap<>();

	public UI()
	{
		Menu menu = new MainMenu();
		this.menus.put(MenuAction.MAIN_MENU, menu);
		this.currentMenu = menu;
		
		this.menus.put(MenuAction.DEVICE_MENU, new DeviceMenu());
		this.menus.put(MenuAction.NETWORK_MENU, new NetworkMenu());
		this.menus.put(MenuAction.ROOM_MENU, new RoomMenu());
		
		/*
		 * To add more menus to the UI :
		 * 1) Define a new action in UIAction
		 * 2) Create a new Menu subclass in ui.menu
		 * 3) Put the action and a corresponding instance of menu in the map here
		 */
	}

	public void start()
	{
		System.out.println("Welcome to TI215 manager!");
	}

	public void end()
	{
		System.out.println("Bye!");
	}

	public Action getNextAction() throws ActionNotFound
	{
		String choice = UI.scanner.next();
		return this.currentMenu.getAction(choice);
	}

	public void switchMenu(Action action) throws MenuNotFound
	{		
		Menu menu = this.menus.get(action);
		if(menu == null)
			throw new MenuNotFound("No menu found for action : " + action.name());		
		
		this.currentMenu = this.menus.get(action);
	}

	public void displayCurrentMenu()
	{
		this.currentMenu.display();
	}
}