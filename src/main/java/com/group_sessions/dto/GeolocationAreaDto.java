package com.group_sessions.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeolocationAreaDto {
    double longitudeNE;
    double latitudeNE;
    double longitudeSW;
    double latitudeSW;
}
