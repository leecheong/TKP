package com.marketapp.marketapp.service;

import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class ProductServiceTest {
    @InjectMocks
    private ProductService p_service;
    @Mock
    private ProductRepository p_repository;




    @Test
    @DisplayName("すべての商品情報を表示")
    void showAllProducts() {
        //given
        List<product> p = new ArrayList<>();
        product pt = new product(101,"test1",5, LocalDate.of(2024, 5, 31),"250",1101,1001);
        product pt2 = new product(102,"test2",6, LocalDate.of(2024, 5, 25),"260",1102,1002);
        p.add(pt);
        p.add(pt2);

        BDDMockito.given(p_repository.findAll()).willReturn(p);

        //when
        List<product> result = p_service.ShowAllProducts();

        //then
        assertThat(result.size()).isEqualTo(2);
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