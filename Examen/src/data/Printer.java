package data;

public class Printer extends Device
{
    int pagePrinted;
    int pageLeft;

    public Printer(String brand, String model, String serialNumber, int power, Room location, Network net) throws DeviceAlreadyExist
    {
        super(brand, model, serialNumber, power, location, net);
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

    public void addPaper(int nbPaper)
    {
        this.pageLeft += nbPaper;
    }

    public void turnOn()
    {
        super.turnOn();

        if (this.isDeviceOn())
            System.out.println("Test page");
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

    public String toString()
    {
        return String.format("%s\nPage printed: %d\nPage left", super.toString(), this.pagePrinted, this.pageLeft);
    }
}
