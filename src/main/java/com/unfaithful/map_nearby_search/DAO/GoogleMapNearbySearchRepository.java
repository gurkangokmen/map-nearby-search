package com.unfaithful.map_nearby_search.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unfaithful.map_nearby_search.DTO.GoogleMapNearbySearchApiResultDTO;

import java.util.List;

public interface GoogleMapNearbySearchRepository {
    List<GoogleMapNearbySearchApiResultDTO> getNearbySearchPlaces(Double latitude, Double longitude, Integer radius) throws JsonProcessingException;
}
