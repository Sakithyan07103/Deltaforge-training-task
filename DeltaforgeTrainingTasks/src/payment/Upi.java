package payment;


public class Upi implements Payment{

    private  String upiId;

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public void sucesssMessage(){
        System.out.println("Payment has been successfully paid through UPI");

    }

    public void failureMessage(){
        System.out.println("Payment has been failed to pay through UPI ");

    }



}
