package com.backpacktravel.skyscanner.client;

import com.backpacktravel.skyscanner.builder.Url;
import com.backpacktravel.skyscanner.configuration.SkyscannerConfig;
import com.backpacktravel.skyscanner.dto.airportDto.AirportDto;
import com.backpacktravel.skyscanner.dto.flightResponseDto.BestFlightDto;
import com.backpacktravel.skyscanner.dto.locationRentACar.LocationRentACarDto;
import com.backpacktravel.skyscanner.dto.rentACarResponseDto.RentACarResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkyscannerClient {

    private final RestTemplate restTemplate;
    private final SkyscannerConfig skyscannerConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(SkyscannerClient.class);

    public List<AirportDto> getAirport(String destination) {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(skyscannerConfig.getSkyscannerApiEndpoint())
                .value("/autocomplete?")
                .queryParams("query=", destination)
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");

        try {
            ResponseEntity<AirportDto[]> response = restTemplate.exchange(url, HttpMethod.GET, request, AirportDto[].class);
            return Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList())
                    .stream()
                    .flatMap(p -> Arrays.stream(p.getBody()))
                    .collect(Collectors.toList());

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public BestFlightDto getBestFlights(String flightDetails) {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(skyscannerConfig.getSkyscannerApiEndpoint())
                .value("/search")
                .queryParams("?", flightDetails)
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");

        try {
            ResponseEntity<BestFlightDto> response = restTemplate.exchange(url, HttpMethod.GET, request, BestFlightDto.class);
            return response.getBody();

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RestClientException(e.getMessage());
        }
    }

    public List<LocationRentACarDto> getLocationsRentACar(String location) {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(skyscannerConfig.getSkyscannerApiEndpoint())
                .value("/autocomplete-rentacar?")
                .queryParams("query=", location)
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");

        try {
            ResponseEntity<LocationRentACarDto[]> response = restTemplate.exchange(url, HttpMethod.GET, request, LocationRentACarDto[].class);
            System.out.println(response);
            return Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList())
                    .stream()
                    .flatMap(p -> Arrays.stream(p.getBody()))
                    .collect(Collectors.toList());

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public RentACarResponseDto getRentACar(String rentACarDetails) {
        Url urlService = new Url.UrlBuilder()
                .apiEndpoint(skyscannerConfig.getSkyscannerApiEndpoint())
                .value("/search-rentacar")
                .queryParams("?", rentACarDetails)
                .build();

        String url = urlService.toString();
        HttpEntity request = createRequest("X-RapidAPI-Host", "X-RapidAPI-Key");

        try {
            ResponseEntity<RentACarResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, request, RentACarResponseDto.class);
            System.out.println(response.getBody());
            return response.getBody();

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RestClientException(e.getMessage());
        }
    }

    private HttpEntity createRequest(String host, String key) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(host, skyscannerConfig.getSkyscannerHost());
        headers.set(key, skyscannerConfig.getSkyscannerKey());

        return new HttpEntity(headers);
    }
}
