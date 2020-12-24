package data;

import java.lang.Math;

import data.exception.DeviceAlreadyExist; 

public class Pc extends Device
{
    Os os;
    int ram;

    public Pc(String brand, String model, String serialNumber, int power, Os os, int ram) throws DeviceAlreadyExist
    {
        super(brand, model, serialNumber, power);

        this.os = os;

        if (ram % 2 == 0)
            this.ram = ram;

        else if (ram >= 1024)
            this.ram = (int)Math.pow(ram % 2, 2.0);

        else
            this.ram = 1024;
    }

    public void turnOn()
    {
        super.turnOn();
        System.out.println(String.format("%s: Welcome", os.name()));
    }
}
