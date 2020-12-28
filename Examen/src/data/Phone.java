package data;

import java.util.ArrayList;

public class Phone extends Device
{
    private String number;
    private static ArrayList<String> numbers;

    public Phone(String brand, String model, String serialNumber, int power, String number, Room location, Network net) throws DeviceAlreadyExist, PhoneNumberAlreadyExist
    {
        super(brand, model, serialNumber, power , location, net);
        if (Phone.numbers == null)
            Phone.numbers = new ArrayList<String>();
        
        if (!numbers.contains(number))
            this.number = number;

        else
            throw new PhoneNumberAlreadyExist(number);
    }

    public void turnOn()
    {
        super.switchPower(true);
        ring();
        ring();
    }

    public void turnOff()
    {
        super.switchPower(false);
    }

    public void ring()
    {
        System.out.println("ring ring");
    }

    public String toString()
    {
        return String.format("%s\nPhone number: %s", super.toString(), this.number);
    }
}
