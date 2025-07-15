package day5.rolldice.loneintrestcalc;

import day5.rolldice.loneintrestcalc.exception.DateException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LoanInterestCalculatorMain {
    public static void main(String[] args) throws ParseException, DateException {

        Scanner sc = new Scanner(System.in);
        LoanInterestCalculator LIC = new LoanInterestCalculator();

        System.out.println("\n");
        System.out.print("==== Welcome to Loan Interest Calculator ====");
        System.out.println();

        System.out.print("Enter Loan amount (in ₹): ");
        int amt = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your starting date: ");
        String dateString = sc.nextLine();
        DateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date date = format.parse(dateString);

        System.out.print("Enter the number of years you will pay the loan: ");
        int loanTime = sc.nextInt();

        LIC.setLoanAmount(amt);
        LIC.setLoanStartDate(date);
        LIC.setLoanDuration(loanTime);
        LIC.setLoanInterestRate();

        System.out.println("\n");
        System.out.println("=====================================================================");

        double amount = (LIC.getLoanAmount() * LIC.getLoanDuration() * LIC.getLoanInterestRate()) / 100.0 ;

        System.out.println("Loan amount: " + LIC.getLoanAmount());
        System.out.println("Starting date for you loan repayment is: " + LIC.getLoanStartDate());
        System.out.println("Number of years you will be paying: " + LIC.getLoanDuration());
        System.out.println("Interest for your loan is: " + LIC.getLoanInterestRate());
        System.out.println("Total amount to be paid in " + LIC.getLoanDuration() + " years is: " + amount );
        System.out.println("Your monthly EMI for " + LIC.getLoanDuration() + " years is: " + amount / (LIC.getLoanDuration() * 12));

    }

}
