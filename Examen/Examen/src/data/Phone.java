package data;

import data.exception.DeviceAlreadyExist;
import data.exception.PhoneNumberAlreadyExist;

import java.util.ArrayList;

public class Phone extends Device
{
    private String number;
    private static ArrayList<String> numbers;

    public Phone(String brand, String model, String serialNumber, int power, String number) throws DeviceAlreadyExist, PhoneNumberAlreadyExist
    {
        super(brand, model, serialNumber, power);

        if (!numbers.contains(number))
            this.number = number;
        else
            throw new PhoneNumberAlreadyExist(number);
    }

    public void turnOn()
    {
        super.turnOn();
        ring();
        ring();
    }

    public void ring()
    {
        System.out.println("ring ring");
    }
}
