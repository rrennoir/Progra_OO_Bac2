package data;

import java.util.ArrayList;

public class Phone extends Device
{
    private static ArrayList<String> numbers = new ArrayList<String>();

    private String number;

    public Phone(String brand, String model, String serialNumber, int power, String number, Room location, Network net) throws DeviceAlreadyExist, PhoneNumberAlreadyExist
    {
        super(brand, model, serialNumber, power, location, net);

        if (!numbers.contains(number))
            this.number = number;

        else
            throw new PhoneNumberAlreadyExist(number);
    }

    public void setNumber(String newNumber)
    {
        this.number = newNumber;
    }

    public void turnOn()
    {
        super.turnOn();
        if (isDeviceOn())
        {
            ring();
            ring();
        }
    }
    public void powerSwitch()
    {
    	if (this.isDeviceOn())
    	{
    		this.turnOff();
    	}
    	else
    	{
    		this.turnOn();
    	}
    }
    public void ring()
    {
        if (this.isDeviceOn())
            System.out.println("ring ring");
    }

    public String toString()
    {
        return String.format("%s\nPhone number: %s", super.toString(), this.number);
    }
}
