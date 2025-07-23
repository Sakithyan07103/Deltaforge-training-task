package com.day11.portfolio_viewer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StockDto {
    private int stockId;
    private final String stockName;
    private final int stockPrice;
}
