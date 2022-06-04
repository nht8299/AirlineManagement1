package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.service.dto.ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateService {

    List<String> findByEmployeeNameIsNguyen(@Param("name") String name);

    List<String> dangTestBoeingNha();
    List<String> dangTestAirBusNha();
    List<String> dangTestAirBusVaBoeingNha(String airCraftName1, String airCraftName2);
    List<Certificate> findByAircraftTypeContaining(String containingWord);

    List<String>findListOfEmployeeFlightMoreThanThreeAircraft();

    List<ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance>ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance();
}
