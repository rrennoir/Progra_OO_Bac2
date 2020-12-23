package data.exception;

public class PhoneNumberAlreadyExist extends Exception
{
    public PhoneNumberAlreadyExist(String number)
    {
        super(String.format("Number: %s already exist !", number));
    }
}
