package weekend1;

public class Stock {
    private int stockId;
    private final String stockName;
    private final int stockPrice;
    private int stockQuantity = 0;

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

           System.out.println("ID: " + stockId);
           System.out.println("Name: " + stockName);
           System.out.println("Price: " + stockPrice);

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
            System.out.println("Quantity of your stock is only " + stockQuantity + " but you are trying to sell " + quantity + " shares ");
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
