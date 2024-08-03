package com.unfaithful.map_nearby_search.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="nearby_search_history")
@NoArgsConstructor
@Getter
@Setter
public class NearbySearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "radius")
    private Integer radius;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToMany(mappedBy = "nearbySearchHistory", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<NearbySearchPlaces> nearbySearchPlaces;

    public void addNearbySearchPlaces(NearbySearchPlaces tempNearbySearchPlaces) {
        if (nearbySearchPlaces == null) {
            nearbySearchPlaces = new ArrayList<>();
        }

        this.nearbySearchPlaces.add(tempNearbySearchPlaces);
        tempNearbySearchPlaces.setNearbySearchHistory(this);
    }

    public NearbySearchHistory(int radius, double latitude, double longitude) {
        this.radius = radius;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
