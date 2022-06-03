package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.dto.NumberOfFlightEachDepartureTerminalDto;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findByArrivalTerminal(String arrivalTerminal);
    List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance);
    List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal,String departureTerminal);
    Integer countByDepartureTerminal(String departureTerminal);
    Optional<Flight> findById(String id);

    List<Flight> findBySpecificAircraftCanExecute(String aircraftType);

    List<Flight> findFlyRounteAround();

    List<NumberOfFlightEachDepartureTerminalDto> numberOfFlightEachDepartureTerminal();
}
