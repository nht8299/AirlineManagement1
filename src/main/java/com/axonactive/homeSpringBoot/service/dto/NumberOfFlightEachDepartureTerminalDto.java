package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberOfFlightEachDepartureTerminalDto {

    private String departureTerminal;
    private long numberOfFlight;
}
