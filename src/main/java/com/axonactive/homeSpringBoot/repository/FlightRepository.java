package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.dto.NumberOfFlightEachDepartureTerminalDto;
import com.axonactive.homeSpringBoot.service.dto.TotalCostOfFlightEachDepartureTerminalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String > {
    //Cho biết các chuyến bay đi Đà Lạt (DAD).
    List<Flight> findByArrivalTerminal(String arrivalTerminal);

    //Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance);

    //Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal,String departureTerminal);

    //Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
//    @Query(value ="SELECT COUNT(f.id) FROM Flight AS f WHERE f.departureTerminal='SaiGon' ")

    List<Flight> findByDistanceLessThan(Integer distance);

  Flight findFirstBy();
   Integer countByDepartureTerminal(String departureTerminal);
   @Query(value = "SELECT a "+
           "FROM Flight a , Flight b WHERE a.departureTerminal = b.arrivalTerminal " +
           "AND b.departureTerminal = a.arrivalTerminal")
   List<Flight> flightRouteAround();

   @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.NumberOfFlightEachDepartureTerminalDto(a.departureTerminal, count(a.id)) " +
           "FROM Flight a " +
           "GROUP BY a.departureTerminal" )
    List<NumberOfFlightEachDepartureTerminalDto> NUMBER_OF_FLIGHT_EACH_DEPARTURE_TERMINAL_DTOS();

   @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.TotalCostOfFlightEachDepartureTerminalDto(a.departureTerminal, count(a.id), sum(a.price)) " +
           "FROM Flight a " +
           "GROUP BY a.departureTerminal")
    List<TotalCostOfFlightEachDepartureTerminalDto> TOTAL_COST_OF_FLIGHT_EACH_DEPARTURE_TERMINAL_DTOS();

    @Query(value = "SELECT a " +
            "FROM Flight a " +
            "WHERE a.departureTime < :time " +
            "ORDER BY a.departureTime")
    List<Flight> listOfFightHaveDepartureTimeBeforeTwelve(@Param("time")LocalTime time);

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.NumberOfFlightEachDepartureTerminalDto(a.departureTerminal, count(a.id)) " +
            "FROM Flight a " +
            "WHERE a.departureTime < :time " +
            "GROUP BY a.departureTerminal" )
    List<NumberOfFlightEachDepartureTerminalDto> NUMBER_OF_FLIGHT_EACH_DEPARTURE_TERMINAL_BEFORE_TWELVE_DTOS(@Param("time")LocalTime time);

    @Query("FROM Flight " +
            "WHERE distance < ANY (SELECT distance FROM Aircraft WHERE type LIKE 'Airbus%' )")
    List<Flight> findFlightCanFlyByAirbusAircraft();
}


