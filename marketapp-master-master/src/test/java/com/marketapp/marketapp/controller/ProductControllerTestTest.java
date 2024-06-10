package com.marketapp.marketapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketapp.marketapp.DTO.productDTO;
import com.marketapp.marketapp.model.product;
import com.marketapp.marketapp.repository.ProductRepository;
import com.marketapp.marketapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
@AutoConfigureWebMvc // 이 어노테이션을 통해 MockMvc를 Builder없이 주입받을 수 있음


class ProductControllerTestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService p_service;

    @Mock
    private ProductRepository p_repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }


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
//        given(p_service.findProduct(P_id)).willReturn(Optional.of(P_Entity));
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
    void addProduct() throws Exception{

    }






}