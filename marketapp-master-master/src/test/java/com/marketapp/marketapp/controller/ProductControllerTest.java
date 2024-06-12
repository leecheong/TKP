package com.marketapp.marketapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.repository.ProductRepository;
import com.marketapp.marketapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@WebMvcTest(ProductController.class)
@AutoConfigureWebMvc // 이 어노테이션을 통해 MockMvc를 Builder없이 주입받을 수 있음


class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ProductService p_service;

    @Autowired
    private ObjectMapper objectMapper;




    @Test
    @DisplayName("すべての情報を読む")
    void getProductTest() throws Exception{
        //given : Mock 객체가 특정 상황에서 해야하는 행위를 정하는 메소드
        List<product> showproduct = new ArrayList<>();
        showproduct.add(new product
                (101,"test1",5,LocalDate.of(2024, 5, 31),"250",1101,1001));
        //stub
        BDDMockito.given(p_service.ShowAllProducts()).willReturn(showproduct);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //then
        BDDMockito.verify(p_service).ShowAllProducts();

    }

    @Test
    @DisplayName("商品検索")
    void searchProduct() throws Exception{

        //given
        Integer P_id = 4;
        product P_Entity = new product(P_id, "test1",5, LocalDate.of(2024,5,31),"250",1101,1001);
        BDDMockito.given(p_service.findProduct(P_id)).willReturn(Optional.of(P_Entity));

        Map<String, Integer> payload = new HashMap<>();
        payload.put("productP_id",P_id);

        mockMvc.perform(MockMvcRequestBuilders.post("/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.p_id").value(P_Entity.getP_id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.p_name").value(P_Entity.getP_name()));
    }


    @Test
    @DisplayName("商品追加")
    void addproduct() throws Exception{
        //given
        product p = new product(121,"test1",5,LocalDate.of(2024,5,31),"300",1101,1002);

        //stub
        BDDMockito.willDoNothing().given(p_service).addproduct(any(product.class));

        //when then
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":121,\"name\":\"test1\",\"quantity\":5,\"expiryDate\":\"2024-05-31\",\"price\":\"300\",\"categoryId\":1101,\"supplierId\":1002}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @DisplayName("修正機能")
    void chaneproduct() throws Exception{

        //given
        Integer pid = 1;
        product p = new product(121,"test1",5,LocalDate.of(2024,5,31),"300",1101,1002);

        //stub
        BDDMockito.willDoNothing().given(p_service).updateProduct(eq(pid),any(product.class));

        //when then
        mockMvc.perform(MockMvcRequestBuilders.put("/change/{p_id}" , pid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"p_id\":121,\"p_name\":\"test1\",\"p_amt\":5,\"p_day\":\"2024-05-31\",\"p_price\":\"300\",\"c_code\":1002,\"s_code\":1101}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        ArgumentCaptor<product> productCaptor = ArgumentCaptor.forClass(product.class);
        BDDMockito.verify(p_service).updateProduct(eq(pid), productCaptor.capture());

        product capturedproduct = productCaptor.getValue();
        assertEquals(p.getP_id(),capturedproduct.getP_id());
        assertEquals(p.getP_name(),capturedproduct.getP_name());
        assertEquals(p.getP_amt(),capturedproduct.getP_amt());
        assertEquals(p.getP_day(), capturedproduct.getP_day());
        assertEquals(p.getP_price(),capturedproduct.getP_price());
        assertEquals(p.getS_code(),capturedproduct.getS_code());
        assertEquals(p.getC_code(),capturedproduct.getC_code());

    }


    @Test
    @DisplayName("削除機能")
    void deleteproduct() throws Exception{
        //given
        Integer p_id = 1;

        //stub
        BDDMockito.willDoNothing().given(p_service).deleteproduct(p_id);

        //when
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{P_id}",p_id))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //then
        BDDMockito.verify(p_service, Mockito.times(1)).deleteproduct(p_id);
    }


}