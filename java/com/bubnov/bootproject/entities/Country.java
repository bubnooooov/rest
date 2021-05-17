package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id",   length = 2)
    private String countryID;

    @Column(name = "country_name", length = 40)
    private String countryName;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "region_id")
    private Region regionID;

    public Country() { }

    public Country(String countryName) {
        this.countryName = countryName;
    }
}
