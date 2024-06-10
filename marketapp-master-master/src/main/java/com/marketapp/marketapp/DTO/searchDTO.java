package com.marketapp.marketapp.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.marketapp.marketapp.model.category;
import com.marketapp.marketapp.model.status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class searchDTO {
    @JsonProperty("p_name")
    String p_name;


    private Integer p_id;
    private int p_amt;
    private String p_day;
    private String p_price;
    private Integer S_code;
    private Integer C_code;

    public searchDTO(Integer p_id, String p_name, int p_amt, String p_day, String p_price, Integer s_code, Integer c_code) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_amt = p_amt;
        this.p_day = p_day;
        this.p_price = p_price;
        this.S_code = s_code;
        this.C_code = c_code;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public int getP_amt() {
        return p_amt;
    }

    public void setP_amt(int p_amt) {
        this.p_amt = p_amt;
    }

    public String getP_day() {

        return p_day;
    }

    public void setP_day(String p_day) {
        this.p_day = p_day;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
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

