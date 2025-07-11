package day4.rolldice.loneintrestcalc.exception;

public class DateException extends Exception{
    public DateException(){
        super();
    }

    @Override
    public String getMessage() {
        return "you can't add previous days date! ";
    }
}
