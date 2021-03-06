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
public class LocationDetailsDto {

    @JsonProperty("flightPlaceId")
    private String flightPlaceId;

    @JsonProperty("parent")
    private ParentDto parentDto;

    @JsonProperty("name")
    private String name;
}
