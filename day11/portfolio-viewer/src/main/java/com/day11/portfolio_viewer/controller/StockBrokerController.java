package com.day11.portfolio_viewer.controller;

import com.day11.portfolio_viewer.dto.Stock;
import com.day11.portfolio_viewer.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class StockBrokerController {
    @Autowired
    StockService stockService;

    @GetMapping("/getall")
    public List<Stock> viewAllStocks() {
        return stockService.viewAllStocks();
    }
}
