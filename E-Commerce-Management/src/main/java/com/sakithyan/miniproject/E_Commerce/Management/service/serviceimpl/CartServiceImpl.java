package com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl;

import com.sakithyan.miniproject.E_Commerce.Management.dao.CartDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.CartItemDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.CustomerDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dao.ProductDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CartDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.CustomerHaventRegisteredException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.productexceptions.ProductDoesNotExistException;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.CartItemMapper;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.CartMapper;
import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.model.Product;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceinterface.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl extends CartService {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CartItemDAO cartItemDAO;

    public CartDTO createCart(int customerId) {
        Customer customer = customerDAO.findById(customerId)
                .orElseThrow(() -> new CustomerHaventRegisteredException("Customer not found"));

        Optional<Cart> existingCart = cartDAO.findByCustomer(customer);

        if (existingCart.isPresent()) {
            return cartMapper.cartToCarDTO(existingCart.get());
        }

        Cart cart = new Cart();
        cart.setCustomer(customer);

        Cart savedCart = cartDAO.savecart(cart);

        return cartMapper.cartToCarDTO(savedCart);
    }

    public CartDTO addToCart(int customerId, int productId, int quantity) {
        Customer customer = customerDAO.findById(customerId)
                .orElseThrow(() -> new CustomerHaventRegisteredException("Customer not found"));

        Cart cart = cartDAO.findByCustomer(customer).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            return cartDAO.savecart(newCart);
        });

        Product product = productDAO.findProductById(productId)
                .orElseThrow(() -> new ProductDoesNotExistException("Product not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setCartProductQuantity(quantity);
        item.setProductTotalPrice((double) product.getProductPrice());
        item.setProductTotalPrice((double) (product.getProductPrice() * quantity));

        cart.getCartItems().add(item); // Add to cart

        double total = cart.getCartItems().stream()
                .mapToDouble(CartItem::getProductTotalPrice)
                .sum();
        cart.setTotalPrice(total);

        cartDAO.savecart(cart);

        return cartMapper.cartToCarDTO(cart);
    }


    public Optional<Customer> getCartByCustomerId(int customerId) {

        return customerDAO.findById(customerId);
    }

    public void clearCart(int customerId) {
    }
}
