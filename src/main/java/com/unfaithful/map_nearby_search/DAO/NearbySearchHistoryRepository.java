package com.unfaithful.map_nearby_search.DAO;

import com.unfaithful.map_nearby_search.Entity.NearbySearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NearbySearchHistoryRepository extends JpaRepository<NearbySearchHistory, Long> {
    NearbySearchHistory findByLatitudeAndLongitudeAndRadius(double latitude, double longitude, int radius);
}
