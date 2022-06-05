package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.service.AircraftService;
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
public class AircraftServiceImplTest {
    @Autowired
    AircraftService aircraftService;

//    2.	Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    @Test
    void testFindByDistanceGreaterThan_shouldReturn4Aircraft_whenInput1000(){
        assertEquals(4,aircraftService.findByDistanceGreaterThan(10000).size());
    }

//    10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.
    @Test
    void testCountByTypeContaining_shouldReturn6_whenInput747(){
        assertEquals(6,aircraftService.countByTypeContaining("Boeing"));
    }

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    @Test
    void testFindAircraftTypeAvailableForSpecificFlight_shouldReturn1_whenInputFlightVN280(){
        assertEquals(1,aircraftService.findAircraftTypeAvailableForSpecificFlight("VN280").size());
    }

//    14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    @Test
    void testFindByType_shouldReturn1_whenInputFlightVN280(){
        assertEquals(0,aircraftService.findByType("Airbus 320").size());
    }

//    Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
    @Test
    void testAircraftTypeStatic_shouldReturnListOf10_whenFound(){

        assertEquals(10,aircraftService.aircraftTypeStaticJPQL().size());
    }

}
