package com.axonactive.homeSpringBoot.service.Impl;

import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.FlightService;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.repository.FlightRepository;
import com.axonactive.homeSpringBoot.service.dto.NumberOfFlightEachDepartureTerminalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AircraftService aircraftService;
    @Override
    public List<Flight> findByArrivalTerminal(String arrivalTerminal) {
        return flightRepository.findByArrivalTerminal(arrivalTerminal);
    }

    @Override
    public List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance) {
        return flightRepository.findByDistanceBetween(minDistance,maxDistance);
    }

    @Override
    public List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal, String departureTerminal) {
        return flightRepository.findByArrivalTerminalAndDepartureTerminal(arrivalTerminal, departureTerminal);
    }

    @Override
    public Integer countByDepartureTerminal(String departureTerminal) {

    return flightRepository.countByDepartureTerminal(departureTerminal);
    }

    @Override
    public Optional<Flight> findById(String id) {
        return flightRepository.findById(id);
    }



    @Override
    public List<Flight> findBySpecificAircraftCanExecute(String aircraftType) {
        return flightRepository.findByDistanceLessThan(aircraftService.findByType(aircraftType).get(0).getDistance());
    }

    @Override
    public List<Flight> findFlyRounteAround() {
        return flightRepository.flightRouteAround();
    }

    @Override
    public List<NumberOfFlightEachDepartureTerminalDto> numberOfFlightEachDepartureTerminal() {
        return flightRepository.NUMBER_OF_FLIGHT_EACH_DEPARTURE_TERMINAL_DTOS();
    }
}
