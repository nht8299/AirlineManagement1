package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.service.dto.AircraftTypeStaticDto;
import com.axonactive.homeSpringBoot.entity.Aircraft;

import java.util.List;
import java.util.Set;

public interface AircraftService {
    List<Aircraft> findByDistanceGreaterThan(Integer minRange);
    Integer countByTypeContaining(String containingWord);
    List<Aircraft> findByTypeContaining (String containingWord);
    Set<String> findAircraftTypeAvailableForSpecificFlight (String flightName);


    List<Aircraft> findByType(String aircraftType);

    List<AircraftTypeStaticDto> aircraftTypeStaticJPQL();
}
