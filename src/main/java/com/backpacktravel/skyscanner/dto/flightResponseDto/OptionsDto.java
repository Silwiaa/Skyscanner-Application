package com.backpacktravel.skyscanner.dto.flightResponseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("items")
    private List<ItemDto> items;
}
