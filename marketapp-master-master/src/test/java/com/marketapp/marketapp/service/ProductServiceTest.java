package com.marketapp.marketapp.service;

import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.repository.ProductRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
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
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class ProductServiceTest {
    @InjectMocks
    private ProductService p_service;
    @Mock
    private ProductRepository p_repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }




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
    @DisplayName("商品探す")
    void findProduct() {

        //given
        Integer Pid = 14;
        product p = new product(102,"test2",6, LocalDate.of(2024, 5, 25),"260",1102,1002);
        //stub
        BDDMockito.given(p_repository.findById(Pid)).willReturn(Optional.of(p));
        //when 必ずOptionalを確認する。
        Optional<product> Fproduct = p_service.findProduct(14);
        //then
        Assertions.assertThat(Fproduct).isPresent();
        Assertions.assertThat(Fproduct.get().getP_id()).isEqualTo(p.getP_id());
        Assertions.assertThat(Fproduct.get().getP_name()).isEqualTo(p.getP_name());
        Assertions.assertThat(Fproduct.get().getP_day()).isEqualTo(p.getP_day());
        Assertions.assertThat(Fproduct.get().getP_price()).isEqualTo(p.getP_price());
        Assertions.assertThat(Fproduct.get().getP_amt()).isEqualTo(p.getP_amt());
        Assertions.assertThat(Fproduct.get().getC_code()).isEqualTo(p.getC_code());
        Assertions.assertThat(Fproduct.get().getS_code()).isEqualTo(p.getS_code());



    }

    @Test
    @DisplayName("商品追加")
    void addproduct() {

        //given
        product p = new product(102,"test2",6, LocalDate.of(2024, 5, 25),"260",1102,1002);
        //when
        p_service.addproduct(p);
        //then
        BDDMockito.verify(p_repository, times(1)).save(p);



    }

    @Test
    @DisplayName("商品修正")
    public void updateProduct() {
        product p = new product(102,"test2",6, LocalDate.of(2024, 5, 25),"260",1102,1002);
        product updateP = new product(102,"test3",7, LocalDate.of(2024, 5, 27),"270",1102,1002);
        //given
        BDDMockito.given(p_repository.findById(102)).willReturn(Optional.of(p));
        //when
        p_service.updateProduct(102,updateP);
        //then
        BDDMockito.verify(p_repository, times(1)).findById(102);
        BDDMockito.verify(p_repository, times(1)).save(p);
        Assertions.assertThat(p.getP_name()).isEqualTo(updateP.getP_name());
        Assertions.assertThat(p.getP_amt()).isEqualTo(updateP.getP_amt());
        Assertions.assertThat(p.getP_price()).isEqualTo(updateP.getP_price());
        Assertions.assertThat(p.getP_day()).isEqualTo(updateP.getP_day());
        Assertions.assertThat(p.getS_code()).isEqualTo(updateP.getS_code());
        Assertions.assertThat(p.getC_code()).isEqualTo(updateP.getC_code());


    }


    @Test
    @DisplayName("商品削除")
    void deleteproduct() {
        //given
        Integer P_id = 12;
        //stub

        //when
        p_service.deleteproduct(P_id);

        //then
        BDDMockito.verify(p_repository).deleteById(P_id);

    }
}