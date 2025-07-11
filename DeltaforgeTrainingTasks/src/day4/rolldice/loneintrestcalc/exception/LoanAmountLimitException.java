package day4.rolldice.loneintrestcalc.exception;

public class LoanAmountLimitException extends RuntimeException {
    public LoanAmountLimitException(String message) {
        super(message);
      System.out.println(message);
    }
}
