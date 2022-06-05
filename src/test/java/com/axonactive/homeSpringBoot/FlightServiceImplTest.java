package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.service.FlightService;
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
public class FlightServiceImplTest {
    @Autowired
    FlightService flightService;

//    1.	Cho biết các chuyến bay đi Đà Lạt (DAD).
    @Test
    void testFindByArrivalTerminal_shouldReturn2_whenInputDAD(){
        assertEquals(2,flightService.findByArrivalTerminal("DAD").size());
    }

//    4.Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    @Test
    void testFindByDistanceBetween_shouldReturn1_whenInput8000And10000(){
        assertEquals(1,flightService.findByDistanceBetween(8000,10000).size());
    }

//    5.Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    @Test
    void testFindByArrivalTerminalAndDepartureTerminal_shouldReturn2_whenInputSGNAndBMV(){
        assertEquals(2,flightService.findByArrivalTerminalAndDepartureTerminal("BMV","SGN").size());
    }

//    6.Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    @Test
    void testCountByDepartureTerminal_shouldReturn8_whenInputSGN(){
        assertEquals(8,flightService.countByDepartureTerminal("SGN"));
    }

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    @Test
    void testFindById_shouldReturnFlightWithIDVN280_whenInputVN280(){
        assertEquals("VN280",flightService.findById("VN280").get().getId());
    }
    //14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    @Test
    void testFindBySpecificAircraftCanExecute_shouldReturn15_whenAirBusA320(){
        assertEquals(15,flightService.findBySpecificAircraftCanExecute("Airbus A320").size());
    }

//    @Test
//    void testfindBySpecificAircraftCanExecute_shouldReturn15_whenAirBusA320(){
//        assertEquals("VN280",flightService.findBySpecificAircraftCanExecute("Airbus A320").size());
//    }

//    17.     Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này.

    @Test
    void testFindFlightRouteAround_shouldReturnListOfOne_whenFound(){
        assertEquals(2,flightService.findFlyRounteAround().size());
    }

//    18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
    @Test
    void testNumberOfFlightEachDepartureTerminal_shouldReturnListOfSix_whenFound(){
        assertEquals(6,flightService.numberOfFlightEachDepartureTerminal().size());
    }
//    19.Với mỗi ga có chuyến  bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.
    @Test
    void testTotalCostOfFlightEachDepartureTerminal_shouldReturnListOfSix_whenFound(){
        assertEquals(6,flightService.totalCostOfFlightEachDepartureTerminal().size());
    }
//    20.     Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
    @Test
    void testListOfFlightHaveDepartureTimeBeforeTwelve_shouldReturnListOfFlight_whenFound(){
        assertEquals(11,flightService.listOfFlightHaveDepartureTimeBeforeTwelve(12,0).size());
    }
//    21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
    @Test
    void testNumberOfFlightEachDepartureTerminal_shouldReturnListOfFlight_whenFound(){
        assertEquals(11,flightService.listOfFlightHaveDepartureTimeBeforeTwelve(12,00).size());
    }

    //    28.Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing.
    @Test
    void testListOfFlightCanFlyByAirbusAircraft_shouldReturnListOfFlight_whenFound(){
        assertEquals(17,flightService.findFlightCanFlyByAirbusAircraft().size());
    }
}

