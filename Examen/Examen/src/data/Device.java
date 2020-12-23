package data;

import java.util.ArrayList;
import data.exception.DeviceAlreadyExist;

public class Device
{
    private static ArrayList<String> deviceIDs;
    private String brand;
    private String model;
    private String serialNumber;
    private int power;
    private boolean isOn;
    // network
    // location

    public Device(String brand, String model, String serialNumber, int power) throws DeviceAlreadyExist
    {
        String deviceID = brand + model + serialNumber;

        if (Device.deviceIDs.contains(deviceID))
            throw new DeviceAlreadyExist(brand, model, serialNumber);
        
        else
        {
            Device.deviceIDs.add(deviceID);
            this.brand = brand;
            this.model = model;
            this.serialNumber = serialNumber;
            this.isOn = false;
            this.power = power;
        }
    }

    public void turnOn()
    {
        if (true/* connected */)
        {
            this.isOn = true;
        }
    }
}
