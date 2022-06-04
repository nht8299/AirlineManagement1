package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalCostOfFlightEachDepartureTerminalDto {
    private String departureTerminal;
    private Long numberOfFlight;
    private double totalCost;
}
