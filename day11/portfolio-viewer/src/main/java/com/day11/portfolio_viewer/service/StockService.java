package com.day11.portfolio_viewer.service;

import com.day11.portfolio_viewer.dto.StockDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    public List<StockDto> viewAllStocks() {
        List<StockDto> stocks = new ArrayList<>();

        stocks.add(new StockDto(101, "Apple", 183));
        stocks.add(new StockDto(202, "Google", 2750));
        stocks.add(new StockDto(303, "Amazon", 134));

        for (StockDto stock : stocks) {
            System.out.println("ID: " + stock.getStockId());
            System.out.println("Name: " + stock.getStockName());
            System.out.println("Price: " + stock.getStockPrice());
        }

        return stocks;
    }
}
