package ti215;

import data.Data;
import manager.ActionMethod;
import manager.Manager;
import manager.exception.ManagerMethodNotFound;
import ui.Action;
import ui.ControlAction;
import ui.ManagerAction;
import ui.MenuAction;
import ui.UI;
import ui.menu.exception.ActionNotFound;
import ui.menu.exception.MenuNotFound;

public class TI215
{
	/*
	 * The main method of the program
	 */
	public static void main(String[] args)
	{
		Manager manager = new Manager();
		Data data = new Data();
		UI ui = new UI();

		ui.start(); // welcome message

		Action action = null;
		ActionMethod method;

		/*
		 * The main loop, goes on until EXIT
		 */
		while (action != ControlAction.EXIT)
		{
			try
			{
				// current menu is displayed to the user
				ui.displayCurrentMenu();

				// user types his choice which corresponds to an action
				action = ui.getNextAction();

				if (action instanceof MenuAction) // if the action is a menu change
				{
					ui.switchMenu(action);
				}
				else if (action instanceof ManagerAction)// if the action is for reading/writing data
				{
					method = manager.getActionMethod(action); // get the corresponding method
					method.execute(ui, data); // execute the method
				}
			}
			catch (ActionNotFound | ManagerMethodNotFound | MenuNotFound e)
			{
				System.out.println(e.getMessage());
			}
		}

		ui.end(); // exit message
	}
}
