package data;

import java.lang.Math; 

public class Pc extends Device
{
    Os os;
    int ram;

    public Pc(String brand, String model, String serialNumber, int power, Os os, int ram, Room location, Network net) throws DeviceAlreadyExist
    {
        super(brand, model, serialNumber, power, location, net);

        this.os = os;

        if (Math.pow(2, 31 - Integer.numberOfLeadingZeros(ram)) == ram)
            this.ram = ram;

        else if (ram >= 1024)
            //this.ram = (int) Math.pow(2, (Math.log(ram) / Math.log(2))); // not recommended
            this.ram = (int) Math.pow(2, 31 - Integer.numberOfLeadingZeros(ram));

        else
            this.ram = 1024;
    }

    public void setOs(Os newOs)
    {
        this.turnOff();
        this.os = newOs;
        this.turnOn();
    }

    public void setRam(int newRam)
    {
        if (newRam % 2 == 0)
            this.ram = newRam;

        else if (newRam >= 1024)
            this.ram = (int)Math.pow(newRam % 2, 2.0);

        else
            this.ram = 1024;
    }

    public void turnOn()
    {
        super.turnOn();

        if (this.isDeviceOn())
            System.out.println(String.format("%s: Welcome", os.name()));
    }

    public void turnOff()
    {
        super.turnOff();
        System.out.println(String.format("%s: Goodbye", os.name()));
    }

    public String toString()
    {
        return String.format("%s\nOs: %s\nRam: %d", super.toString(), this.os.name(), this.ram);
    }
}
