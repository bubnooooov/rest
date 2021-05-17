package com.bubnov.bootproject.dto;

import lombok.Data;

@Data
public class ItemDTOLocation {
    private int locationID;
    private String locationAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryID;
}
