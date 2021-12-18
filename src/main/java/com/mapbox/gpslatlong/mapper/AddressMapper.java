package com.mapbox.gpslatlong.mapper;

import com.mapbox.gpslatlong.dto.AddressDTO;
import com.mapbox.gpslatlong.entity.Address;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {

    public Address toEntity(AddressDTO addressDTO){
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setLatitude(addressDTO.getLatitude());
        address.setLongitude(addressDTO.getLongitude());
        return address;
    }

    public AddressDTO toDTO(Address address){
        if (address == null) return null;
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setLatitude(address.getLatitude());
        addressDTO.setLongitude(address.getLongitude());
        return addressDTO;
    }

    public List<AddressDTO> toListDTO(List<Address> addressList){
        if (addressList.isEmpty()) return null;
        List<AddressDTO> addressDTOS = new ArrayList<>();

        for (Address address : addressList){
            addressDTOS.add(toDTO(address));
        }

        return addressDTOS;
    }
}
