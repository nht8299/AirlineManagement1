package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.service.dto.AircraftTypeStaticDto;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
  List<Aircraft> findByDistanceGreaterThan(Integer minRange);
  Integer countByTypeContaining(String containingWord);

  List<Aircraft> findByTypeContaining(String containingWord);
  List<Aircraft> findByType(String type);

  @Query(value =
          "SELECT new com.axonactive.homeSpringBoot.service.dto.AircraftTypeStaticDto(a.id, a.type, count(c.employee.id))" +
          "FROM Aircraft a left join Certificate c on a.id = c.aircraft.id " +
          "GROUP BY a.id")
  List<AircraftTypeStaticDto> aircraftTypeStaticJPQL();


}
