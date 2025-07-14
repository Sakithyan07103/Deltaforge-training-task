package day4.rolldice.loneintrestcalc;

import day4.rolldice.loneintrestcalc.exception.DateException;
import day4.rolldice.loneintrestcalc.exception.LoanAmountLimitException;
import day4.rolldice.loneintrestcalc.exception.LoanDurationLimitException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanInterestCalculator {

    private int loanAmount;
    private Date loanStartDate;
    private int loanDuration;
    private int loanInterestRate;

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) throws ParseException, DateException {
        DateFormat format1 = new SimpleDateFormat("dd MM yyyy");
        Date todayDate = null;
        try{
            todayDate   = format1.parse("11 07 2025");
        } catch (ParseException e) {
            System.out.println("invalid date format");
        }

        if (loanStartDate.after(todayDate)) {
            this.loanStartDate = loanStartDate;
        } else {
            throw new DateException(" you can't add previous days date!");
        }
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        if (loanDuration > 0 && loanDuration <=30){
            this.loanDuration = loanDuration;
        } else {
            throw new LoanDurationLimitException(" you can't pay this loan for more than 30 years");
        }
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        if (loanAmount < 1000) {
            throw new LoanAmountLimitException("Loan amount should be at least 1000");
        } else if (loanAmount >= 10000000) {
            throw new LoanAmountLimitException("Loan amount should be less than 10000000");
        } else {
            this.loanAmount = loanAmount;
        }
    }

    public int getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate() {
        if (loanDuration > 0 && loanDuration < 5) {
            this.loanInterestRate = 8;
        } else if (loanDuration >= 5 && loanDuration < 10) {
            this.loanInterestRate = 10;
        } else if (loanDuration >= 10) {
            this.loanInterestRate = 15;
        }
    }
}
