package com.backpacktravel.skyscanner.facade;

import com.backpacktravel.skyscanner.dto.airportDto.AirportDto;
import com.backpacktravel.skyscanner.dto.flightResponseDto.BestFlightDto;
import com.backpacktravel.skyscanner.dto.locationRentACar.LocationRentACarDto;
import com.backpacktravel.skyscanner.dto.rentACarResponseDto.RentACarResponseDto;
import com.backpacktravel.skyscanner.service.SkyscannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SkyscannerFacade {
    private final SkyscannerService skyscannerService;

    public List<AirportDto> fetchSkyscannerAirports(String airport) {
        return skyscannerService.fetchSkyscannerAirports(airport);
    }

    public BestFlightDto fetchSkyscannerBestFlights(String flightDetails) {
        return skyscannerService.fetchSkyscannerBestFlights(flightDetails);
    }

    public List<LocationRentACarDto> fetchSkyscannerLocationsRentACar(String location) {
        return skyscannerService.fetchSkyscannerLocationsRentACar(location);
    }

    public RentACarResponseDto fetchSkyscannerRentACar(String rentACarDetails) {
        return skyscannerService.fetchSkyscannerRentACar(rentACarDetails);
    }
}
