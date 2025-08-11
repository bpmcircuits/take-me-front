package com.kodilla.tripplannerfront.mapper;

import com.kodilla.tripplannerfront.dto.FlightOfferDTO;
import com.kodilla.tripplannerfront.tripplanerback.dto.flights.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightOffersMapperTest {

    private final FlightMapper mapper = new FlightMapper();

    @Test
    void shouldMapFlightSearchResponseToFlightOfferDTOs() {
        // Given
        List<FlightSearchResponseDTO> responses = createSampleFlightSearchResponses();

        // When
        List<FlightOfferDTO> result = mapper.mapFromResponseToFlightOfferDTOs(responses);

        // Then
        assertNotNull(result);
        assertEquals(6, result.size()); // 2 outbound segments + 2 inbound segments from first response + 2 outbound segments from second response

        // Verify first outbound segment from first response
        FlightOfferDTO firstOffer = result.get(0);
        assertEquals("LO", firstOffer.airline());
        assertEquals(LocalDateTime.parse("2025-08-13T05:40:00"), firstOffer.departureTime());
        assertEquals("KTW", firstOffer.from());
        assertEquals(LocalDateTime.parse("2025-08-13T06:30:00"), firstOffer.arrivalTime());
        assertEquals("WAW", firstOffer.to());
        assertEquals("EUR 1093.49", firstOffer.cost());

        // Verify first inbound segment from first response
        FlightOfferDTO thirdOffer = result.get(2);
        assertEquals("LO", thirdOffer.airline());
        assertEquals(LocalDateTime.parse("2025-08-15T06:30:00"), thirdOffer.departureTime());
        assertEquals("LHR", thirdOffer.from());
        assertEquals(LocalDateTime.parse("2025-08-15T09:55:00"), thirdOffer.arrivalTime());
        assertEquals("WAW", thirdOffer.to());
        assertEquals("EUR 1093.49", thirdOffer.cost());
    }

    private List<FlightSearchResponseDTO> createSampleFlightSearchResponses() {
        List<FlightSearchResponseDTO> responses = new ArrayList<>();

        // First response - round trip
        List<FlightSegmentDTO> outboundSegments1 = List.of(
                new FlightSegmentDTO("KTW", "WAW", "LO", "2025-08-13T05:40:00", "2025-08-13T06:30:00"),
                new FlightSegmentDTO("WAW", "LHR", "LO", "2025-08-13T07:25:00", "2025-08-13T09:20:00")
        );

        List<FlightSegmentDTO> inboundSegments1 = List.of(
                new FlightSegmentDTO("LHR", "WAW", "LO", "2025-08-15T06:30:00", "2025-08-15T09:55:00"),
                new FlightSegmentDTO("WAW", "KTW", "LO", "2025-08-15T13:40:00", "2025-08-15T14:30:00")
        );

        FlightBoundDTO outbound1 = new FlightBoundDTO("PT4H40M", 280, outboundSegments1);
        FlightBoundDTO inbound1 = new FlightBoundDTO("PT7H", 420, inboundSegments1);
        PriceDTO totalPrice1 = new PriceDTO("EUR", "1093.49");

        List<TravelerPriceDTO> travelerPrices1 = List.of(
                new TravelerPriceDTO("ADULT", new PriceDTO("EUR", "390.85")),
                new TravelerPriceDTO("ADULT", new PriceDTO("EUR", "390.85")),
                new TravelerPriceDTO("CHILD", new PriceDTO("EUR", "311.79"))
        );

        FlightSearchResponseDTO response1 = new FlightSearchResponseDTO(false, outbound1, inbound1, totalPrice1, travelerPrices1);

        // Second response - round trip with different outbound
        List<FlightSegmentDTO> outboundSegments2 = List.of(
                new FlightSegmentDTO("KTW", "WAW", "LO", "2025-08-13T11:55:00", "2025-08-13T12:45:00"),
                new FlightSegmentDTO("WAW", "LHR", "LO", "2025-08-13T15:30:00", "2025-08-13T17:20:00")
        );

        FlightBoundDTO outbound2 = new FlightBoundDTO("PT6H25M", 385, outboundSegments2);
        FlightSearchResponseDTO response2 = new FlightSearchResponseDTO(false, outbound2, inbound1, totalPrice1, travelerPrices1);

        responses.add(response1);
        responses.add(response2);

        return responses;
    }
}