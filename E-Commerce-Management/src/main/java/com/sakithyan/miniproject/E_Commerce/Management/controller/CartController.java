    package com.sakithyan.miniproject.E_Commerce.Management.controller;

    import com.sakithyan.miniproject.E_Commerce.Management.dto.CartDTO;
    import com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl.CartServiceImpl;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/cart")
    public class CartController {

        @Autowired
        private CartServiceImpl cartService;

        @PostMapping("/{customerId}")
        public CartDTO createCart(@PathVariable int customerId) {
            return cartService.createCart(customerId);
        }

        @PostMapping("/{customerId}/{productId}/{quantity}")
        public CartDTO addToCart(@PathVariable int customerId,
                                 @PathVariable int productId,
                                 @PathVariable int quantity) {
            return cartService.addToCart(customerId, productId, quantity);
        }

        // View customer cart
//        @GetMapping("/{customerId}")
//        public CartDTO viewCart(@PathVariable int customerId) {
//            return cartService.getCartByCustomerId(customerId);
//        }
//
//        // Clear cart (optional endpoint)
//        @DeleteMapping("/clear/{customerId}")
//        public void clearCart(@PathVariable int customerId) {
//            cartService.clearCart(customerId);
//        }
    }
