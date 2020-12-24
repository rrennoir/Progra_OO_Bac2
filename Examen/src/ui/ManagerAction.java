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
	EDIT_DEVICE, // Edit a device

	LIST_NETWORKS, // List all networks
	SHOW_NETWORK, // Display info about a network and list devices connected to it

	LIST_ROOMS, // List all rooms
	SHOW_ROOM, // Display info about a room and list devices inside it
}
