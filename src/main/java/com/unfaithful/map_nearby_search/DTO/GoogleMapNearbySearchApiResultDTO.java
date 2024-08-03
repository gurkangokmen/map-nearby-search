package com.unfaithful.map_nearby_search.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"icon", "icon_background_color", "icon_mask_base_uri", "opening_hours", "business_status", "price_level", "rating", "reference", "scope", "types", "user_ratings_total"})
public class GoogleMapNearbySearchApiResultDTO {
    private String place_id;
    private String name;
    private String vicinity;
    private Geometry geometry;

    private String icon;
    private String icon_background_color;
    private String icon_mask_base_uri;
    private Open opening_hours;
    private String business_status;
    private int price_level;
    private double rating;
    private String reference;
    private String scope;
    private String[] types;
    private int user_ratings_total;
}
