package com.marketapp.marketapp.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode

public class productDTO {
    public Integer P_id;
    public String P_price;
    public Integer P_amt;
    public LocalDate P_day;
    public String P_name;
    public Integer S_code;
    public Integer C_code;

    public productDTO(Integer p_id, String p_name, int p_amt, LocalDate p_day, String p_price, Integer s_code, Integer c_code) {
        this.P_id = p_id;
        this.P_name = p_name;
        this.P_amt = p_amt;
        this.P_day = p_day;
        this.P_price = p_price;
        this.S_code = s_code;
        this.C_code = c_code;
    }


    public Integer getP_id() {
        return P_id;
    }

    public void setP_id(Integer p_id) {
        P_id = p_id;
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
