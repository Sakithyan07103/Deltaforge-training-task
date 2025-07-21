package com.day11.portfolio_viewer;

import com.day11.portfolio_viewer.authentication.CustomerAuthentication;
import com.day11.portfolio_viewer.dto.Customer;
import com.day11.portfolio_viewer.dto.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockBroker {
    static List<Stock> stockList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Customer currentCustomer = null;

    public static void main(String[] args) {

        Stock stock1 = new Stock(1, "Reliane Power", 65);
        Stock stock2 = new Stock(2, "GTL Infra", 3);

        stockList.add(stock1);
        stockList.add(stock2);

        customerLoginInfo();

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

    public static void customerLoginInfo() {
        while (currentCustomer == null) {
            System.out.println("=== Welcome ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Press any number: ");
            int option = sc.nextInt();
            sc.nextLine();

            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if (option == 1) {
                currentCustomer = CustomerAuthentication.customerLogin(username, password);
            } else if (option == 2) {
                CustomerAuthentication.customerRegister(username, password);
            }
        }
    }

    public static void viewAllStocks() {
        for (Stock stocks : stockList) {
            stocks.viewAllStocks();
            System.out.println("---");
        }

        System.out.println("\n");
    }

    public static void viewMyStock() {
        System.out.println(currentCustomer.getUsername() + "'s portfolio: ");
        currentCustomer.viewCustomerPortfolio();
    }

    public static void buyStock() {
        System.out.print("Enter your stock ID: ");
        int id = sc.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();

        for (Stock stocks : stockList) {
            if (stocks.getStockId() == id) {
                currentCustomer.buyCustomerStock(stocks, quantity);
            }
        }

        System.out.println();
    }

    public static void sellStock() {
        System.out.print("Enter your stock ID: ");
        int id = sc.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();

        for (Stock stocks : stockList) {
            if (stocks.getStockId() == id) {
                currentCustomer.sellCustomerStock(stocks, quantity);
            }
            System.out.println();
        }
    }
}
