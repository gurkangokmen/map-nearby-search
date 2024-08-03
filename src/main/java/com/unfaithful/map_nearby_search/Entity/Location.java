package com.unfaithful.map_nearby_search.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Location {

    @Column(name = "latitude")
    private double lat;

    @Column(name = "longitude")
    private double lng;
}
