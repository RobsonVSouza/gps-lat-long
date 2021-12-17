package com.mapbox.gpslatlong.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapBoxFeaturesDTO {

    private String id;
    private Double relevance;

    @JsonAlias("place_name")
    private String placeName;

    private MapBoxGeometryDTO geometry;

}
