package com.unfaithful.map_nearby_search.Controller;

import com.unfaithful.map_nearby_search.Entity.NearbySearchPlaces;
import com.unfaithful.map_nearby_search.Service.NearbySearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nearby-search-history-api")
@CrossOrigin(origins = "http://localhost:5173")
public class NearbySearchHistoryController {
    private final NearbySearchHistoryService nearbySearchHistoryService;

    @Autowired
    public NearbySearchHistoryController(NearbySearchHistoryService nearbySearchHistoryService) {
        this.nearbySearchHistoryService = nearbySearchHistoryService;
    }

    @GetMapping("/nearby-search-history-feign/lat/{lat}/lng/{lng}/radius/{radius}")
    public List<NearbySearchPlaces> getNearbySearchHistory(@PathVariable(name = "lat") double latitude, @PathVariable(name = "lng") double longitude,@PathVariable int radius) {
        return this.nearbySearchHistoryService.getNearbySearchHistory(latitude, longitude, radius);
    }
}
