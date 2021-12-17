package com.mapbox.gpslatlong.api;

import com.mapbox.gpslatlong.dto.CoordinatesDTO;
import com.mapbox.gpslatlong.dto.MapBoxResponseDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class RestTemplateMapBox {

    public CoordinatesDTO consumerAPI(String address){
        RestTemplate template = new RestTemplate();
        CoordinatesDTO coordinatesDTO = new CoordinatesDTO();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.mapbox.com")
                .path("geocoding/v5/mapbox.places/" + address + ".json")
                .queryParam("access_token","pk.eyJ1IjoiZGFuaWVseHNhbnRvcyIsImEiOiJja3dleGpvZHYwOTI3Mm9wd25xcDlkM3FyIn0.JFwnkjlyDMXlIc88Rdq-GQ")
                .build();

        ResponseEntity<MapBoxResponseDTO> entity = template.getForEntity(uri.toUriString(), MapBoxResponseDTO.class);

        if(entity.getStatusCodeValue() == 200){
            System.out.println("Coordenadas do endereço " + address);
            System.out.println("Latitude " + entity.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(1));
            System.out.println("Longitude: " + entity.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(0) + "\n");
            coordinatesDTO.setLatitude(entity.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(0));
            coordinatesDTO.setLongitude(entity.getBody().getFeatures().get(0).getGeometry().getCoordinates().get(1));
        }
        return coordinatesDTO;
    }
}
