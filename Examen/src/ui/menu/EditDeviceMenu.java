package ui.menu;

import ui.ManagerAction;
import ui.MenuAction;

public class EditDeviceMenu extends Menu
{
    public EditDeviceMenu()
    {
        this.addItem("1 - Edit brand (All type)", ManagerAction.EDIT_BRAND);
        this.addItem("2 - Edit model (All type)", ManagerAction.EDIT_MODEL);
        this.addItem("3 - Edit serial number (All type)", ManagerAction.EDIT_SERIAL_NUMBER);
        this.addItem("4 - Edit power (All type)", ManagerAction.EDIT_POWER);
        this.addItem("5 - Edit room (All type)", ManagerAction.EDIT_ROOM);
        this.addItem("6 - Edit network (All type)", ManagerAction.EDIT_NETWORK);
        this.addItem("7 - Edit OS (PC type)", ManagerAction.EDIT_OS);
        this.addItem("8 - Edit RAM (PC type)", ManagerAction.EDIT_RAM);
        this.addItem("9 - Edit phone number (Phone type)", ManagerAction.EDIT_NUMBER);
        this.addItem("M - Device Menu", MenuAction.DEVICE_MENU);
    }
}
