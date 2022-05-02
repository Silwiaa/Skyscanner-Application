package com.backpacktravel.skyscanner.dto.flightResponseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestFlightDto {

    @JsonProperty("itineraries")
    private ItineraryDto itineraries;

    @JsonProperty("context")
    private ContextDto context;
}
