package com.marketapp.marketapp.controller;


import com.marketapp.marketapp.DTO.productDTO;
import com.marketapp.marketapp.DTO.searchDTO;
import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Controller
public class ProductController {

    @Autowired
    private ProductService p_service;
    @Autowired
    private HttpRequestHandlerAdapter httpRequestHandlerAdapter;

    //main backend
    @GetMapping("/")
    public List<product> showAllProducts() {

        return p_service.ShowAllProducts();
    }

    //add product backend
    @PostMapping("/add")
    public void addProduct(@RequestBody product p) {

        p_service.addproduct(p);

    }

    @PostMapping("/search")
    public Optional<product> searchProduct(@RequestBody Map<String, Integer> payload) {
        Integer P_id = payload.get("productP_id");
        Optional<product> productList = p_service.findProduct(P_id);
        if (!productList.isEmpty()) {
            return Optional.of(productList.get());
        } else {
            return Optional.empty();
        }
    }

    @PutMapping("/change/{P_id}")
    public void updateProduct(@RequestBody product p, @PathVariable("P_id") Integer p_id) {

        p_service.updateProduct(p_id, p);
    }

    @DeleteMapping("/delete/{P_id}")
    public void deleteproduct(@PathVariable("P_id") Integer P_id) {
        p_service.deleteproduct(P_id);
    }



}
