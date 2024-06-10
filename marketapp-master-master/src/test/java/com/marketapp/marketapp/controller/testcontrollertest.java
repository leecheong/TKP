package com.marketapp.marketapp.controller;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;

public class testcontrollertest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforAll Annotation スタート");
        System.out.println();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("## afterAll Annotation スタート");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("## beforeEach Annotation スタート");
        System.out.println();
    }

    @AfterEach
    void afterEach(){
        System.out.println("## afterEach Annotation スタート");
        System.out.println();
    }

    @Test
    void test1(){
        System.out.println("## test1 スタート");
        System.out.println();
    }

    @Test
    @DisplayName("test case2!!")
    void test2(){
        System.out.println("test case2 スタート");
        System.out.println();
    }

    @Test
    @Disabled
    void test3(){
        System.out.println("## test3 スタート");
        System.out.println();
    }

}
