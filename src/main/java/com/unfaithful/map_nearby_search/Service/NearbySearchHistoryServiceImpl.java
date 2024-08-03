package com.unfaithful.map_nearby_search.Service;


import com.unfaithful.map_nearby_search.DAO.NearbySearchHistoryRepository;
import com.unfaithful.map_nearby_search.Entity.NearbySearchHistory;
import com.unfaithful.map_nearby_search.Entity.NearbySearchPlaces;
import com.unfaithful.map_nearby_search.Proxy.NearbySearchGoogleApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NearbySearchHistoryServiceImpl implements NearbySearchHistoryService {
    private final NearbySearchHistoryRepository nearbySearchHistoryRepository;

    @Autowired
    private NearbySearchGoogleApiProxy proxy;

    @Autowired
    public NearbySearchHistoryServiceImpl(NearbySearchHistoryRepository nearbySearchHistoryRepository) {
        this.nearbySearchHistoryRepository = nearbySearchHistoryRepository;
        //this.proxy=proxy;
    }

    @Override
    public void saveNearbySearchHistory(Integer radius, Double latitude, Double longitude) {
        NearbySearchHistory nearbySearchHistory = new NearbySearchHistory(radius, latitude, longitude);
        this.nearbySearchHistoryRepository.save(nearbySearchHistory);
    }

    @Override
    public List<NearbySearchPlaces> getNearbySearchHistory(Double latitude, Double longitude, Integer radius) {
        NearbySearchHistory nearbySearchHistoryDb = this.nearbySearchHistoryRepository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);
        if (nearbySearchHistoryDb != null) {
            System.out.println("Nearby Search History Found in DB");
            return nearbySearchHistoryDb.getNearbySearchPlaces();
        }

        else {
            System.out.println("Nearby Search History Not Found in DB");
            List<NearbySearchPlaces> nearbySearchPlacesList = proxy.retrieveNearbySearchPlaces(latitude,longitude,radius);

            NearbySearchHistory nearbySearchHistory = new NearbySearchHistory(radius,latitude,longitude);
            //nearbySearchHistory.setNearbySearchPlaces(nearbySearchPlacesList);

            for (NearbySearchPlaces nearbySearchPlace : nearbySearchPlacesList) {
                nearbySearchPlace.setNearbySearchHistory(nearbySearchHistory);
                nearbySearchHistory.addNearbySearchPlaces(nearbySearchPlace);
            }

            nearbySearchHistoryRepository.save(nearbySearchHistory);
            return nearbySearchPlacesList;
        }


    }
}
