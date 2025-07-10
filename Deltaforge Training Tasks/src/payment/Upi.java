package payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Upi implements Payment{

    private  String upiId;

    public void sucesssMessage(){
        System.out.println("Payment has been successfully paid through UPI");

    }

    public void failureMessage(){
        System.out.println("Payment has been failed to pay through UPI ");

    }



}
