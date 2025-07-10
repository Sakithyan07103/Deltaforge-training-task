package payment;


import java.util.Date;

public class CreditCard implements Payment {

    private String cardName;
    private String cardNum;
    private Date cardDate;
    private int cardCvv;


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getCardDate() {
        return cardDate;
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public int getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(int cardCvv) {
        this.cardCvv = cardCvv;
    }

    public void sucesssMessage(){
        System.out.println("Payment has been successfully paid through credit card ");
    }

    public void failureMessage(){
        System.out.println("Payment has been failed to pay through credit card ");

    }

}
