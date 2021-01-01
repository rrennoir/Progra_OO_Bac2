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
    private Network network;

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
            this.location.addDevToRoom(this);
            this.NetInterface = new Netint(net.getNewIp());
            this.network = net;
        }
    }

    public int getId()
    {
        return this.id;
    }

    public void setBrand(String newBrand) throws DeviceAlreadyExist
    {
        String newDeviceId = newBrand + this.model + this.serialNumber;

        if (!Device.deviceIDs.contains(newDeviceId))
        {
            Device.deviceIDs.remove(this.brand + this.model + this.serialNumber);
            this.brand = newBrand;
            Device.deviceIDs.add(newDeviceId);
        }
        else
            throw new DeviceAlreadyExist(this.brand, this.model, this.serialNumber);
    }

    public void setModel(String newModel) throws DeviceAlreadyExist
    {
        String newDeviceId = this.brand + newModel + this.serialNumber;

        if (!Device.deviceIDs.contains(newDeviceId))
        {
            Device.deviceIDs.remove(this.brand + this.model + this.serialNumber);
            this.model = newModel;
            Device.deviceIDs.add(newDeviceId);
        }
        else
            throw new DeviceAlreadyExist(this.brand, this.model, this.serialNumber);
    }

    public void setSerialNumber(String newSerialNumber) throws DeviceAlreadyExist
    {
        String newDeviceId = this.brand + this.model + newSerialNumber;

        if (!Device.deviceIDs.contains(newDeviceId))
        {
            Device.deviceIDs.remove(this.brand + this.model + this.serialNumber);
            this.serialNumber = newSerialNumber;
            Device.deviceIDs.add(newDeviceId);
        }
        else
            throw new DeviceAlreadyExist(this.brand, this.model, this.serialNumber);
    }

    public void setPower(int power)
    {
        this.turnOff();
        this.power = power;
        this.turnOn();
    }

    public void setLocation(Room newLocation)
    {
        this.turnOff();
        this.location.delDevFromRoom(this);
        this.location = newLocation;
        this.location.addDevToRoom(this);
        this.turnOn();
    }

    public void setNetwork(Network newNetwork)
    {
        this.network.DelIp(this.NetInterface.getIp());
        this.network = newNetwork;
        this.NetInterface = new Netint(this.network.getNewIp());
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

    public void turnOn()
    {
        if (this.location.increaseLoad(this.power))
            this.isOn = true;

        else
            System.out.println("Room doesn't have enough power to enable this device.");
    }

    public void turnOff()
    {
        this.isOn = false;
        this.location.decreaseLoad(this.power);
    }

    public void delSelf()
    {
        this.turnOff();
        this.location.delDevFromRoom(this);
        this.network.DelIp(this.NetInterface.getIp());
    }

    public String toString()
    {
        return String.format("Id: %d\nBrand: %s\nModel: %s\nSerialNumber: %s\nPower: %d\nIP: %s", this.id, this.brand, this.model, this.serialNumber, this.power, this.NetInterface.getIp());
    }

    private static int getUniqueId()
    {
        int id = Device.idCounter;
        Device.idCounter += 1;

        return id;
    }
    
    public Network getNetwork() 
	{
		return this.network;
	}
}
