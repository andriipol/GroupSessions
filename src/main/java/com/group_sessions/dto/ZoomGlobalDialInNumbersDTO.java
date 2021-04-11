package com.group_sessions.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZoomGlobalDialInNumbersDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String country;

    private String country_name;

    private String city;

    private String number;

    private String type;

    @Override
    public String toString() {
        return "ZoomGlobalDialInNumbersDTO [city=" + getCity() + ", country=" + getCountry() + ", country_name=" + getCountry_name()
                + ", number=" + getNumber() + ", type=" + getType() + "]";
    }
}
