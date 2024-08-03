package com.unfaithful.map_nearby_search.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfaithful.map_nearby_search.DTO.GoogleMapNearbySearchApiResponseDTO;
import com.unfaithful.map_nearby_search.DTO.GoogleMapNearbySearchApiResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class GoogleMapNearbySearchRepositoryImpl implements GoogleMapNearbySearchRepository{
    @Value("${google.map.api.key}")
    private String apiKey;

    private ObjectMapper objectMapper;

    @Autowired
    public GoogleMapNearbySearchRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<GoogleMapNearbySearchApiResultDTO> getNearbySearchPlaces(Double latitude, Double longitude, Integer radius) throws JsonProcessingException {
        Object ObjectNearbySearchPlaces = new RestTemplate()
                .getForObject(
                        "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latitude + "," + longitude + "&radius=" + radius + "&key=" + apiKey,
                Object.class
                );
        //System.out.println("TEST");
        //System.out.println(ObjectNearbySearchPlaces);

        ResponseEntity<String> response = new RestTemplate()
                .getForEntity(
                        "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latitude + "," + longitude + "&radius=" + radius + "&key=" + apiKey,
                        String.class
                );

        //System.out.println("TEST");
        //System.out.println(response);
        //System.out.println(response.getBody());
        //GoogleMapNearbySearchApiResponseDTO googleMapNearbySearchApiResponseDTO = objectMapper.readValue(ObjectNearbySearchPlaces.toString(), GoogleMapNearbySearchApiResponseDTO.class);

        GoogleMapNearbySearchApiResponseDTO googleMapNearbySearchApiResponseDTO = objectMapper.readValue(response.getBody(), GoogleMapNearbySearchApiResponseDTO.class);

        return googleMapNearbySearchApiResponseDTO.getResults() ;
    }
}
