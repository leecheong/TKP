package com.marketapp.marketapp.repository;

import com.marketapp.marketapp.model.product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ProductRepositoryTest {
    @Autowired
    ProductRepository P_repository;

    @Test
    @DisplayName("repository save")
    public void savetest() {

        product P_Entity = new product(12, "test1",5, LocalDate.of(2024,5,31),"250",1101,1001);

        product saveProduct = P_repository.save(P_Entity);

        assertThat(saveProduct).isNotNull();
        assertThat(saveProduct.getP_id()).isNotNull();
        assertThat(saveProduct.getP_name()).isEqualTo("test1");
        assertThat(saveProduct.getP_price()).isEqualTo("250");
        assertThat(saveProduct.getP_day()).isEqualTo(LocalDate.of(2024,5,31));
        assertThat(saveProduct.getP_amt()).isEqualTo(5);
        assertThat(saveProduct.getS_code()).isEqualTo(1101);
        assertThat(saveProduct.getC_code()).isEqualTo(1001);

    }

    @Test
    @DisplayName("IDを使って商品情報を探す")
    void findById() {
        product P_entity = new product(12, "test1",5, LocalDate.of(2024,5,31),"250",1101,1001);
        product savedProduct = P_repository.save(P_entity);
        Optional<product> foundProduct = P_repository.findById(savedProduct.getP_id());

        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getP_name()).isEqualTo("test1");
        assertThat(foundProduct.get().getP_amt()).isEqualTo(5);
        assertThat(foundProduct.get().getP_day()).isEqualTo(LocalDate.of(2024,5,31));
        assertThat(foundProduct.get().getP_price()).isEqualTo("250");
        assertThat(foundProduct.get().getS_code()).isEqualTo(1101);
        assertThat(foundProduct.get().getC_code()).isEqualTo(1001);

    }

    @Test
    @DisplayName("商品削除")
    public void Deletetest() {
        product P_entity = new product(12, "test1",5, LocalDate.of(2024,5,31),"250",1101,1001);

        product savedProduct = P_repository.save(P_entity);
        P_repository.deleteById(savedProduct.getP_id());

        Optional<product> deleteProduct = P_repository.findById(savedProduct.getP_id());

        assertThat(deleteProduct).isNotPresent();
    }






}