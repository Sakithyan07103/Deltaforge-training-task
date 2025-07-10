package payment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PaymentMain   {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        CreditCard creditcard = new CreditCard();
        Upi upi = new Upi();
        Payment hdfcBank = new CreditCard();

        boolean paymentContinue = true;

        while (true){

            System.out.print("==== Welcome to the Payment Console ====");
            System.out.println();

            System.out.print("     Enter payment amount (in ₹): ");
            int amt = sc.nextInt();
            sc.nextLine();

            System.out.print("Choose payment method: Cash / CreditCard / UPI ");
            String paymentMethod = sc.nextLine();


            if (paymentMethod.equalsIgnoreCase("Cash")) {
                System.out.println("pay the amount " + amt + " to the cashier ");
            }
            if(amt >= 100){
                if (paymentMethod.equalsIgnoreCase("CreditCard")) {
                    System.out.print("Enter card number: ");
                    String cardNum = sc.nextLine();


                    System.out.print("Enter card holder name: ");
                    String cardName = sc.nextLine();


                    System.out.print("Enter expiry date ");
                    String stringDate = sc.nextLine();
                    DateFormat format = new SimpleDateFormat("MM yyyy");
                    Date cardDate = format.parse(stringDate);


                    System.out.print("Enter CVV: ");
                    int cardCvv = sc.nextInt();

                    System.out.println("Processing credit card payment of ₹" + amt);
                    System.out.println("Charged to card ending with " + cardNum.substring(cardNum.length() - 4));

                    DateFormat format1 = new SimpleDateFormat("MM yyyy");
                    Date referDate = format1.parse("07 2025");
                    if (cardNum.length() == 16 && !cardNum.contains("-") && (cardCvv>99 && cardCvv < 1000) && cardDate.after(referDate)){
                        creditcard.sucesssMessage();
                    } else {
                        creditcard.failureMessage();
                    }
                }
            }else{
                System.out.println("Minimum amount to use credit card is 100₹");
            }

            if (paymentMethod.equalsIgnoreCase("Upi")) {
                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                System.out.println("Processing UPI payment of ₹" + amt);
                System.out.println("Charged to UPI ID   " + upiId);
                if (upiId.contains(Upi.userName) && upiId.contains("@")) {
                    upi.sucesssMessage();
                } else {
                    upi.failureMessage();
                }
            }

        }

    }
}

