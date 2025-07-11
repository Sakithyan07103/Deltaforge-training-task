package day4.rolldice.loneintrestcalc.exception;

public class LoanDurationLimitException extends RuntimeException {
    public LoanDurationLimitException() {
        super();
    }

    @Override
    public String getMessage(){
        return "you can't pay this loan for more than 30 years";
    }
}
