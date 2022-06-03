package com.axonactive.homeSpringBoot.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftTypeStaticDto {
    private Integer airCraftId;
    private String airCraftType;
    private Long pilotCount;
}
