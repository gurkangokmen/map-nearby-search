package com.unfaithful.map_nearby_search.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nearby_search_places")
@NoArgsConstructor
@Getter
@Setter
public class NearbySearchPlaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_id")
    private String place_id;

    @Column(name = "name")
    private String name;

    @Column(name = "vicinity")
    private String vicinity;

    @Embedded
    private Geometry geometry;

    //@Column(name = "latitude")
    //private Double latitude;

    //@Column(name = "longitude")
    //private Double longitude;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "nearby_search_history_id")
    @JsonBackReference
    private NearbySearchHistory nearbySearchHistory;

    public NearbySearchPlaces(String place_id, String name, String vicinity, Geometry geometry) {
        this.place_id = place_id;
        this.name = name;
        this.vicinity = vicinity;
        this.geometry = geometry;
    }
}
