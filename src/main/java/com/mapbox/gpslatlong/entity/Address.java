package com.mapbox.gpslatlong.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String street;

    @Column
    private Integer number;

    @Column
    private String city;

    @Column
    private Double latitude;

    @Column
    private Double longitude;



    
}
