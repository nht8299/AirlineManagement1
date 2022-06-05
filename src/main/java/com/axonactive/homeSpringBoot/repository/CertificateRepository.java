package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.service.dto.ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance;
import com.axonactive.homeSpringBoot.service.dto.PilotIdAndNumberOfAircraftCanFlyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Query(nativeQuery = true, value = "SELECT DISTINCT aircraft_id " +
            "FROM certificates " +
            "WHERE employee_id IN (SELECT id FROM employee WHERE name LIKE :name%) ")
    List<String> findByEmployeeName(@Param("name") String name);

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    @Query(nativeQuery = true, value = "SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE 'Boeing%') ")
    List<String> dangTestBoeingNha();

    @Query(nativeQuery = true, value = "SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE LEFT(type,6) = 'Airbus') ")
    List<String> dangTestAirBusNha();

    @Query(nativeQuery = true, value = "SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE :airCraftName1%) " +
            "INTERSECT " +
            "SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE :airCraftName2%) ")
    List<String> dangTestAirBusVaBoeingNha(@Param("airCraftName1") String airCraftName1, @Param("airCraftName2") String airCraftName2);

    List<Certificate> findByAircraftTypeContaining(String containingWord);

    @Query("SELECT a.employee.id " +
            "FROM Certificate a " +
            "GROUP BY a.employee.id " +
            "HAVING count(a.aircraft.id) = 3")
    List<String> ListOfEmployeeIdCanFlightThreeOfMoreAircraft();

    @Query("Select new com.axonactive.homeSpringBoot.service.dto.ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance" +
            "(a.employee.id, MAX(b.distance)) " +
            "FROM Certificate a, Aircraft b " +
            "WHERE a.aircraft.id = b.id " +
            "AND a.employee.id = ANY " +
                                    "(SELECT employee.id " +
                                    "FROM Certificate " +
                                    "GROUP BY employee.id " +
                                    "HAVING count(aircraft.id) > 3) " +
            "GROUP BY a.employee.id " +
            "ORDER BY a.employee.id")
    List<ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance> LIST_OF_PILOT_CAN_FLIGHT_MORE_THAN_THREE_AIRCRAFT_AND_BIGGEST_FLY_DISTANCES();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.PilotIdAndNumberOfAircraftCanFlyDto(employee.id,count (aircraft.id)) " +
            "FROM Certificate " +
            "GROUP BY employee.id")
    List<PilotIdAndNumberOfAircraftCanFlyDto> listOfPilotIdAndNumberOfAircraftCanFly();
}