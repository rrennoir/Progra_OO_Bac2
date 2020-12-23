package data;

import data.exception.DeviceAlreadyExist;

public class Printer extends Device
{
    int pagePrinted;
    int pageLeft;

    public Printer(String brand, String model, String serialNumber, int power) throws DeviceAlreadyExist
    {
        super(brand, model, serialNumber, power);
        this.pagePrinted = 0;
        this.pageLeft = 0;
    }

    public void print(String text)
    {
        if (this.pageLeft > 0)
        {
            this.pagePrinted++;
            this.pageLeft--;
        }
        System.out.println(text);
    }

    public void turnOn()
    {
        super.turnOn();

        System.out.println("Test page");
    }
}
