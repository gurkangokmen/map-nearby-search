package com.unfaithful.map_nearby_search.Proxy;

import com.unfaithful.map_nearby_search.Entity.NearbySearchPlaces;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// I do not write url property because I use Eureka Naming Server Load Balancing.
// I fetch the url from Eureka Naming Server.


@FeignClient(name = "MAP-NEARBY-SEARCH-GOOGLE-API")
public interface NearbySearchGoogleApiProxy {

    @GetMapping("/google-nearby-search-api/lat/{lat}/lng/{lng}/radius/{radius}")
    public List<NearbySearchPlaces> retrieveNearbySearchPlaces(
            @PathVariable(name = "lat") Double latitude,
            @PathVariable(name = "lng") Double longitude,
            @PathVariable Integer radius);
}
