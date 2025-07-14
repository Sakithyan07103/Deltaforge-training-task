package weekend1;

public class Stock {
    private int stockId;
    private final String stockName;
    private final int stockPrice;
    private int stockQuantity;

    public Stock(int stockId, String stockName, int stockPrice) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public void viewAllStocks() {
       if(stockQuantity > 0) {
           System.out.println("ID: " + stockId);
           System.out.println("Name: " + stockName);
           System.out.println("Price: " + stockPrice);
       } else if (stockQuantity == 0) {
           System.out.println("you have no stock to view! ");
       }
    }

    public void buyStock(int quantity) {
        stockQuantity += quantity;
        System.out.println("You have bought " + stockQuantity + " shares of " + stockName);
    }

    public void sellStock(int quantity) {

        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            System.out.println("You have sold " + quantity + " shares of " + stockName) ;
        } else if(quantity == 0){
            System.out.println("You haven't sold any shares of any stocks ");
        } else {
            System.out.println("you didn't have much shares to buy in this stock");
        }
    }

    public void viewMyStocks() {
        if (stockQuantity > 0){
            System.out.println("ID: " + stockId );
            System.out.println("Name: " + stockName);
            System.out.println("Price: " + stockPrice);
            System.out.println("You owned: " + stockQuantity + " shares ");
        }
    }

}
