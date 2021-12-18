package com.mapbox.gpslatlong.controller;

import com.mapbox.gpslatlong.dto.AddressDTO;
import com.mapbox.gpslatlong.entity.Address;
import com.mapbox.gpslatlong.mapper.AddressMapper;
import com.mapbox.gpslatlong.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mapbox.gpslatlong.service.AddressService;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/program")
public class ProgramController {

    @Autowired
    private AddressService service;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;


    @GetMapping(value = "/init ")
    public List<AddressDTO> readFile() {
        return service.readFile();
    }

    @GetMapping(value = "/{id}")
    public AddressDTO findById(@PathVariable Long id) {
        Address address = addressRepository.getById(id);
        return addressMapper.toDTO(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(addressDTO))));
    }

    @GetMapping(value = "/{street}")
    public AddressDTO findbyStreet(@PathVariable String street) {
        return addressMapper.toDTO(addressRepository.findBySreet(street));
    }

    @GetMapping(value = "/{address}")
    public List<AddressDTO> findbyCity (@PathVariable String city) {
        return addressMapper.toListDTO(addressRepository.findByCity(city));
    }
}
