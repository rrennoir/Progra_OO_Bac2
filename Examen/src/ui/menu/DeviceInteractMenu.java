package ui.menu;

import ui.ManagerAction;
import ui.MenuAction;

public class DeviceInteractMenu extends Menu
{
	public DeviceInteractMenu()
	{
		this.addItem("1 - DevicePowerSwitch (All type)", ManagerAction.DEVICE_POWER_SWITCH);
		this.addItem("2 - RoomPowerOff (All type)", ManagerAction.ROOM_POWER_OFF);
		this.addItem("3 - Ring (Phone type)", ManagerAction.RING);
		this.addItem("4 - Print(Printer type)", ManagerAction.PRINT);
		this.addItem("5 - AddPaper(Printer type)", ManagerAction.ADD_PAPER);
		this.addItem("M - Device Menu", MenuAction.DEVICE_MENU);
	}
}
