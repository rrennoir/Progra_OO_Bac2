package data;

import java.util.ArrayList;

public class Device
{
    private static int idCounter = 0;
    private static ArrayList<String> deviceIDs = new ArrayList<String>();

    private String brand;
    private String model;
    private String serialNumber;
    private int id;
    private int power;
    private boolean isOn;
    private Netint NetInterface;
    private Room location;

    public Device(String brand, String model, String serialNumber, int power, Room location, Network net) throws DeviceAlreadyExist
    {
        String deviceID = brand + model + serialNumber;
        
        if (Device.deviceIDs.contains(deviceID))
            throw new DeviceAlreadyExist(brand, model, serialNumber);
        
        else
        {
            Device.deviceIDs.add(deviceID);
            this.id = getUniqueId();
            this.brand = brand;
            this.model = model;
            this.serialNumber = serialNumber;
            this.isOn = false;
            this.power = power;
            this.location = location;
            this.NetInterface = new Netint(net.getNewIp());
        }
    }

    public int getId()
    {
        return this.id;
    }

    public boolean isDeviceOn()
    {
        return this.isOn;
    }

    public Netint getNetworkInterface()
    {
        return this.NetInterface;
    }

    public Room getLocation()
    {
        return this.location;
    }

    public int powerGive() 
    {
    	return this.power;
    }
    public void switchPower(boolean value)
    {
    	this.isOn = value;
    }

    public String toString()
    {
        return String.format("Id: %d\nBrand: %s\nModel: %s\nSerialNumber: %s", this.id, this.brand, this.model, this.serialNumber);
    }

    private static int getUniqueId()
    {
        int id = Device.idCounter;
        Device.idCounter += 1;

        return id;
    }
}
