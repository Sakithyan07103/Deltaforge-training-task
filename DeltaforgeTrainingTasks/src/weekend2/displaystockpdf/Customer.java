package weekend2.displaystockpdf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String username;
    private String password;
    private List<PdfStock> myStocks = new ArrayList<>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void buyCustomerStock(PdfStock stock, int quantity) {
        boolean alreadyOwned = false;
        for (PdfStock s : myStocks){
            if (s.getStockId() == stock.getStockId()) {
                s.buyStock(quantity);
                alreadyOwned = true;
                break;
            }
        }
        if (!alreadyOwned) {
            PdfStock newStock = new PdfStock(stock.getStockId(), stock.getStockName(), stock.getStockPrice(), 0);
            newStock.buyStock(quantity);
            myStocks.add(newStock);
        }
        System.out.println("Stock has been successfully purchased! ");
    }

    public void sellCustomerStock(PdfStock stock, int quantity) {
        boolean alreadyOwned = false;
        for (PdfStock s : myStocks) {
            if (s.getStockId() == stock.getStockId()){
                s.sellStock(quantity);
                alreadyOwned = true;
                break;
            }
            if (!alreadyOwned) {
                System.out.println("You didn't own this stock to sell! ");
            }
            System.out.println("Stock has been successfully sold! ");
        }
    }

    public void viewCustomerPortfolio() {
        System.out.println("Portfolio of: " + username);
        if (myStocks.isEmpty()){
            System.out.println("you own now stocks!");
        } else {
            for (PdfStock s : myStocks) {
                s.viewMyStocks();
            }
        }
        System.out.println();
    }

}
