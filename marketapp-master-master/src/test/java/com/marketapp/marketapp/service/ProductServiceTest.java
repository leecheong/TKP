package com.marketapp.marketapp.service;

import com.marketapp.marketapp.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class ProductServiceTest {
    @InjectMocks
    private ProductService p_service;
    @Mock
    private ProductRepository p_repository;


    @Test
    void showAllProducts() {
    }

    @Test
    void findProduct() {
    }

    @Test
    @DisplayName("商品情報を探す")
    void addproduct() {

    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteproduct() {
    }
}