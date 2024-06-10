    package com.marketapp.marketapp.model;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "status")
    public class status {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "S_id")
        private Integer s_id;

        @Column(name = "S_name")
        private String s_name;

        public Integer getS_id() {
            return s_id;
        }

        public void setS_id(Integer s_id) {
            this.s_id = s_id;
        }

        public String getS_name() {
            return s_name;
        }

        public void setS_name(String s_name) {
            this.s_name = s_name;
        }

        public product getProductEntity() {
            return productEntity;
        }

        public void setProductEntity(product productEntity) {
            this.productEntity = productEntity;
        }

        @ManyToOne
        @JoinColumn(name = "S_code")  // 외래 키의 컬럼명
        private product productEntity;  // 다른 엔티티의 객체 참조

    }
