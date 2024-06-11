package com.marketapp.marketapp.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode

public class productDTO {
    private String P_price;
    private Integer P_amt;
    private LocalDate P_day;
    private String P_name;
    private Integer S_code;
    private Integer C_code;

    public productDTO(String number, int i, LocalDate of, String pen, int i1, int i2) {
    }


    public String getP_price() {
        return P_price;
    }

    public void setP_price(String p_price) {
        P_price = p_price;
    }

    public Integer getP_amt() {
        return P_amt;
    }

    public void setP_amt(Integer p_amt) {
        P_amt = p_amt;
    }

    public LocalDate getP_day() {
        return P_day;
    }

    public void setP_day(LocalDate p_day) {
        P_day = p_day;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public Integer getS_code() {
        return S_code;
    }

    public void setS_code(Integer s_code) {
        S_code = s_code;
    }

    public Integer getC_code() {
        return C_code;
    }

    public void setC_code(Integer c_code) {
        C_code = c_code;
    }


}
