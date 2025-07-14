package weekend1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StockBroker {
    static List<Stock> stockList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Stock stock1 = new Stock(1, "Reliane Power", 65);
        Stock stock2 = new Stock(2, "GTL Infra", 3);

        stockList.add(stock1);
        stockList.add(stock2);

     while (true) {
         System.out.println("==== Welcome to Stock Broker application ====");
         System.out.println(" 1. View list of stocks");
         System.out.println(" 2. View my portfolio");
         System.out.println(" 3. Buy a stock");
         System.out.println(" 4. Sell a stock");
         System.out.println(" 5. Exit");

         System.out.print("Press any number: ");
         int num = sc.nextInt();

         if (num == 1) {
             viewAllStocks();
         } else if (num == 2) {
             viewMyStock();
         } else if (num == 3) {
             buyStock();
         } else if (num == 4) {
             sellStock();
         } else if (num == 5) {
             System.out.println(" Application exited! ");
             break;
         }
     }

    }

    public static void viewAllStocks() {

        for (Stock stocks : stockList) {
            stocks.viewAllStocks();
        }

        System.out.println("\n");
    }

    public static void viewMyStock() {
        boolean myStock = false;

        if (!myStock) {
        for (Stock stocks : stockList) {
            stocks.viewMyStocks();
            myStock = true;
          }
        } else if (myStock) {
            System.out.println("You have no stock to view");
            System.out.println("\n");
        }
    }

    public static void buyStock() {
        System.out.print("Enter your stock ID: ");
        int id = sc.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();

        for (Stock stocks : stockList) {
            if (stocks.getStockId() == id) {
                stocks.buyStock(quantity);
            } else if (stocks.getStockId() != id) {
                System.out.println("incorrect ID ");
                break;
            }
        }
        System.out.println("\n");

    }

    public static void sellStock() {
        System.out.print("Enter your stock ID: ");
        int id = sc.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();

        for (Stock stocks : stockList) {
            if (stocks.getStockId() == id) {
                stocks.sellStock(quantity);
            } else if (stocks.getStockId() != id) {
                System.out.println("incorrect ID ");
                break;
            }
        }
        System.out.println("\n");
    }
}
