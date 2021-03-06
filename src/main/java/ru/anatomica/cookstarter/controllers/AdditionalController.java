package ru.anatomica.cookstarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdditionalController {

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logouts")
    public String logoutPage() {
        return "logout";
    }

    @GetMapping("/products")
    public String productsPage() {
        return "all_products";
    }

    @GetMapping("/products/add_or_edit_product")
    public String addOrEditProductPage() {
        return "add_or_edit_product";
    }
    
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/order_info")
    public String createOrder() {
        return "order_info";
    }

    @GetMapping("/order_result")
    public String createOrderResult() {
        return "order_result";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

}