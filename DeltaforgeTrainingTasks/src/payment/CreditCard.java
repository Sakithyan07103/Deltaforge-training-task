package payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard implements Payment {

    public void sucesssMessage(){
        System.out.println("Payment has been successfully paid through credit card ");
    }

    public void failureMessage(){
        System.out.println("Payment has been failed to pay through credit card ");

    }

}
