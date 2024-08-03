package com.unfaithful.map_nearby_search.DAO;

import com.unfaithful.map_nearby_search.Entity.NearbySearchPlaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NearbySearchPLacesRepository extends JpaRepository<NearbySearchPlaces, Long> {
}
