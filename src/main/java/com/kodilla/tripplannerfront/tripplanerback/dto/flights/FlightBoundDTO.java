package com.kodilla.tripplannerfront.tripplanerback.dto.flights;

import java.util.List;

public record FlightBoundDTO(
        String durationIso,
        Integer durationMinutes,
        List<FlightSegmentDTO> segments
) {}
