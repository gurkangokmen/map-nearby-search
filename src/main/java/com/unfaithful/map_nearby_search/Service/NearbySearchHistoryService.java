package com.unfaithful.map_nearby_search.Service;

import com.unfaithful.map_nearby_search.Entity.NearbySearchPlaces;

import java.util.List;

public interface NearbySearchHistoryService {
    void saveNearbySearchHistory(Integer radius, Double latitude, Double longitude);
    List<NearbySearchPlaces> getNearbySearchHistory(Double latitude, Double longitude, Integer radius);
}
