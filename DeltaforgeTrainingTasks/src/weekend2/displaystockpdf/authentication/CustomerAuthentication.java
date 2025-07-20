package weekend2.displaystockpdf.authentication;

import weekend2.displaystockpdf.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerAuthentication {
    private static final Map<String , Customer> user = new HashMap<>();

    public static void customerRegister(String username, String password) {
        if (user.containsKey(username)) {
            System.out.println("username already exist! ");
        } else {
            Customer newCustomer = new Customer(username, password);
            user.put(username, newCustomer);
            System.out.println("Registraion successfully done for: " + username);
        }
    }

    public static Customer customerLogin(String username, String password) {
        if (!user.containsKey(username)) {
            System.out.println("Username not found! ");
        }

        Customer customer = user.get(username);
        if (customer.getPassword().equals(password)) {
            System.out.println("Login successfull for " + username);
            return customer;
        }else {
            System.out.println("invalid password! ");
            return customer;
        }
    }
}
