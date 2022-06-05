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

//    11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Test
    void testCertificateService_shouldReturn7_whenInputNguyen(){
        assertEquals(7,certificateService.findByEmployeeNameIsNguyen("Nguyen").size());
    }

//    12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    @Test
    void testDangTestAirBusVaBoeingNha(){
        assertEquals(4,certificateService.dangTestAirBusVaBoeingNha("Boeing","Airbus").size());
    }

//    15.	Cho biết tên của các phi công lái máy bay Boeing.
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

    //    24.     Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
    @Test
    void testListOfPilotAndNumberOfAircraftCanFly_shouldReturnList_whenFound(){
        assertEquals(12,certificateService.listOfPilotAndNumberOfAircraftCanFly().size());
    }

}
