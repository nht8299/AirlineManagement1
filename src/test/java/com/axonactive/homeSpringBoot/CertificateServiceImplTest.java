package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.service.CertificateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CertificateServiceImplTest {
    @Autowired
    CertificateService certificateService;

    @Test
    void testCertificateService_shouldReturn7_whenInputNguyen(){
        assertEquals(7,certificateService.findByEmployeeNameIsNguyen("Nguyen").size());
    }

    @Test
    void testDangTestBoeingNha(){
        assertEquals(28,certificateService.dangTestBoeingNha().size());
    }

    @Test
    void testDangTestAirBusNha(){
        assertEquals(11,certificateService.dangTestAirBusNha().size());
    }

    @Test
    void testDangTestAirBusVaBoeingNha(){
        assertEquals(4,certificateService.dangTestAirBusVaBoeingNha("Boeing","Airbus").size());
    }

    @Test
    void testFindByAircraftTypeContaining_shouldReturn28_WhenInputBoeing(){
        assertEquals(28,certificateService.findByAircraftTypeContaining("Boeing").size());
    }

//    22.     Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    @Test
    void testFindListOfEmployeeCanFlightMoreThanThreeAircraft_shouldReturnListOfEmployeeId_whenFound(){
        assertEquals(2,certificateService.findListOfEmployeeFlightMoreThanThreeAircraft().size());
    }
//    23.     Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.
    @Test
    void testListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance_shouldReturnListOfPilot_whenFound(){
        assertEquals(4,certificateService.ListOfPilotCanFlightMoreThanThreeAircraftAndBiggestFlyDistance().size());
    }
}
