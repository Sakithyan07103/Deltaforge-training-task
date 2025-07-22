package com.day11.portfolio_viewer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    public List<Stock> viewAllStocks() {
//           System.out.println("ID: " + stockId);
//           System.out.println("Name: " + stockName);
//           System.out.println("Price: " + stockPrice);
//        return null;

        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock(001, "Apple", 183));
        stocks.add(new Stock(002, "Google", 2750));
        stocks.add(new Stock(003, "Amazon", 134));

        for (Stock stock : stocks) {
            System.out.println("ID: " + stock.getStockId());
            System.out.println("Name: " + stock.getStockName());
            System.out.println("Price: " + stock.getStockPrice());
        }

        return stocks;

    }

    public void buyStock(int quantity) {
        stockQuantity += quantity;
        System.out.println("You have bought " + quantity + " shares of " + stockName);
    }

    public void sellStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            System.out.println("You have sold " + quantity + " shares of " + stockName) ;
        } else if(quantity == 0){
            System.out.println("You haven't sold any shares of any stocks ");
        } else {
            System.out.println("Quantity of your stock is only " + stockQuantity
                    + " but you are trying to sell " + quantity + " shares ");
        }
    }

    public void viewMyStocks() {
        if (stockQuantity > 0){
            System.out.println("ID: " + stockId);
            System.out.println("Name: " + stockName);
            System.out.println("Price: " + stockPrice);
            System.out.println("You owned: " + stockQuantity + " shares ");
        }
    }
}
