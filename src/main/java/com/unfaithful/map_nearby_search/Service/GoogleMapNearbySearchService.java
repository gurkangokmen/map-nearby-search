package com.unfaithful.map_nearby_search.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unfaithful.map_nearby_search.DTO.GoogleMapNearbySearchApiResultDTO;

import java.util.List;

public interface GoogleMapNearbySearchService {
    List<GoogleMapNearbySearchApiResultDTO> getNearbySearchPlaces(Double latitude, Double longitude, Integer radius) throws JsonProcessingException;
}
