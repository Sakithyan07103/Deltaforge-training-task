package com.day11.portfolio_viewer.service;

import com.day11.portfolio_viewer.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    public List<Stock> viewAllStocks() {
        //return  stock.viewAllStocks();
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
}
