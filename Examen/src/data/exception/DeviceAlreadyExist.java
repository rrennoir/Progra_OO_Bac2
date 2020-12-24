package data.exception;

public class DeviceAlreadyExist extends Exception
{
    public DeviceAlreadyExist(String brand, String model, String serialNumber)
    {
        super(String.format("Device with\nBrand: %s\nModel: %s\nSerial Number: %s\nAlready exist !", brand, model, serialNumber));
    }
}
