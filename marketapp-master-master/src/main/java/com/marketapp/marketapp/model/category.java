package com.marketapp.marketapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_id")
    private Integer C_id;

    @Column(name = "C_name")
    private String C_name;

    @ManyToOne
    @JoinColumn(name = "C_code")  // 외래 키의 컬럼명
    private product productEntity;  // 다른 엔티티의 객체 참조

    public Integer getC_id() {
        return C_id;
    }

    public void setC_id(Integer c_id) {
        C_id = c_id;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public product getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(product productEntity) {
        this.productEntity = productEntity;
    }
}
