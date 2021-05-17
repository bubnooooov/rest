package com.bubnov.bootproject.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "regions")
public class Region {

    @Id
    // already in my db exist four entity, => initialValue = 5
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(name = "region_id")
    private int regionID;

    @Column(name = "region_name", length = 25)
    private String regionName;

    public Region() { }

    public Region(String regionName) { this.regionName = regionName; }
}
