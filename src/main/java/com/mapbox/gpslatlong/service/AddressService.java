package com.mapbox.gpslatlong.service;

import com.mapbox.gpslatlong.api.RestTemplateMapBox;
import com.mapbox.gpslatlong.dto.AddressDTO;
import com.mapbox.gpslatlong.dto.CoordinatesDTO;
import com.mapbox.gpslatlong.mapper.AddressMapper;
import com.mapbox.gpslatlong.repository.AddressRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private RestTemplateMapBox restTemplateMapBox;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;

    public List<AddressDTO> readFile(){

        String path ="/home/robson/dev/<address>.csv"; //mudar local

        List<AddressDTO> list = new ArrayList<AddressDTO>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null){

                String[] vect = line.split(",");
                String street = vect[0];
                Integer number =Integer.parseInt(vect[1]);
                String city = vect[2];

                AddressDTO addressDTO = new AddressDTO(street, number, city);
                list.add(addressDTO);

                line = br.readLine();
            }
            System.out.println("List: ");
            for (AddressDTO address : list){
                System.out.println(address);
                CoordinatesDTO coordinatesDTO = restTemplateMapBox.consumerAPI(address.toString2());
                address.setLatitude(coordinatesDTO.getLatitude());
                address.setLongitude(coordinatesDTO.getLongitude());
                addressRepository.save(addressMapper.toEntity(address));
            }

        }
        catch (IOException e){
            System.out.println("Error " + e.getMessage());

        }
        return list;
    }


}
