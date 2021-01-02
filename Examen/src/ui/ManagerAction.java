package ui;

/*
 * Any action requiring the manager to read/write data 
 */
public enum ManagerAction implements Action
{
	LIST_DEVICES, // List all devices
	SHOW_DEVICE, // Display info about a device	
	ADD_DEVICE, // Add a device
	DELETE_DEVICE, // Delete a device

	EDIT_BRAND,
	EDIT_MODEL,
	EDIT_SERIAL_NUMBER,
	EDIT_POWER,
	EDIT_ROOM,
	EDIT_NETWORK,
	EDIT_OS,
	EDIT_RAM,
	EDIT_NUMBER,

	DEVICE_POWER_SWITCH, // Switch on or off a device
	ROOM_POWER_OFF, // Switch every device in a room off
	RING, // Ring a phone device
	PRINT, // Use the printer
	ADD_PAPER, // Add paper to the printer

	LIST_NETWORKS, // List all networks
	SHOW_NETWORK, // Display info about a network and list devices connected to it

	LIST_ROOMS, // List all rooms
	SHOW_ROOM, // Display info about a room and list devices inside it
}
