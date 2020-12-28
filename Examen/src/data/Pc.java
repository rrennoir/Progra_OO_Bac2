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

        if (ram % 2 == 0)
            this.ram = ram;

        else if (ram >= 1024)
            this.ram = (int)Math.pow(ram % 2, 2.0);

        else
            this.ram = 1024;
    }

    public void turnOn()
    {
        super.switchPower(true);;
        System.out.println(String.format("%s: Welcome", os.name()));
    }

    public void turnOff()
    {
        super.switchPower(false);
        System.out.println(String.format("%s: Goodbye", os.name()));
    }
}
