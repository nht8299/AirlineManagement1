package com.axonactive.homeSpringBoot.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PilotIdAndNumberOfAircraftCanFlyDto {
    private String id;
    private Long numberOfAircraft;
}
