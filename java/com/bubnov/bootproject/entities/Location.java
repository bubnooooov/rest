package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "location_id",    length = 4)
    private int locationID;

    @Column(name = "street_address", length = 40)                   private String locationAddress;
    @Column(name = "postal_code",    length = 12)                   private String postalCode;
    @Column(name = "city",           length = 30, nullable = false) private String city;
    @Column(name = "state_province", length = 25)                   private String stateProvince;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "country_id")
    private Country countryID;

    public Location() { }

    public Location(String locationAddress, String postalCode, String city, String stateProvince) {
        this.locationAddress = locationAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
    }
}

