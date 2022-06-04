package com.axonactive.homeSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance {
    private String employeeId;
    private int Distance;
}
