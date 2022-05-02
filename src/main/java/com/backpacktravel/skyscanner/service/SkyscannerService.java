package com.backpacktravel.skyscanner.service;

import com.backpacktravel.skyscanner.client.SkyscannerClient;
import com.backpacktravel.skyscanner.dto.airportDto.AirportDto;
import com.backpacktravel.skyscanner.dto.flightResponseDto.BestFlightDto;
import com.backpacktravel.skyscanner.dto.locationRentACar.LocationRentACarDto;
import com.backpacktravel.skyscanner.dto.rentACarResponseDto.RentACarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkyscannerService {
    private final SkyscannerClient skyscannerClient;

    public List<AirportDto> fetchSkyscannerAirports(String airport) {
        return skyscannerClient.getAirport(airport);
    }

    public BestFlightDto fetchSkyscannerBestFlights(String flightDetails) {
        return skyscannerClient.getBestFlights(flightDetails);
    }

    public List<LocationRentACarDto> fetchSkyscannerLocationsRentACar(String location) {
        return skyscannerClient.getLocationsRentACar(location);
    }

    public RentACarResponseDto fetchSkyscannerRentACar(String rentACarDetails) {
        return skyscannerClient.getRentACar(rentACarDetails);
    }
}
