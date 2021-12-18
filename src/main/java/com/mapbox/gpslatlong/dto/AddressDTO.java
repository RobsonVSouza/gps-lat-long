package com.mapbox.gpslatlong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO{

    private Long id;
    private String street;
    private Integer number;
    private String city;
    private Double latitude;
    private Double longitude;

    public AddressDTO(String street, Integer number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;
    }


    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", City='" + city + '\'' +
                '}';
    }

    public String toString2(){
        return street + "," + number +"," + city;
    }
}
