package com.mapbox.gpslatlong.repository;

import com.mapbox.gpslatlong.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


    Address findBySreet(String street);

    Address findByCity(String city);

}
