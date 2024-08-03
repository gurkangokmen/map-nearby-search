package com.unfaithful.map_nearby_search.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unfaithful.map_nearby_search.DAO.GoogleMapNearbySearchRepository;
import com.unfaithful.map_nearby_search.DTO.GoogleMapNearbySearchApiResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleMapNearbySearchServiceImpl implements GoogleMapNearbySearchService{
    private final GoogleMapNearbySearchRepository googleMapNearbySearchRepository;

    @Autowired
    public GoogleMapNearbySearchServiceImpl(GoogleMapNearbySearchRepository googleMapNearbySearchRepository) {
        this.googleMapNearbySearchRepository = googleMapNearbySearchRepository;
    }
    @Override
    public List<GoogleMapNearbySearchApiResultDTO> getNearbySearchPlaces(Double latitude, Double longitude, Integer radius) throws JsonProcessingException {
        return this.googleMapNearbySearchRepository.getNearbySearchPlaces(latitude, longitude, radius);
    }
}
