package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.service.EmployeeService;
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
public class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    //    25.Tìm các nhân viên không phải là phi công.

    @Test
    void testFindEmployeeWhoAreNotPilot_shouldReturnListOfEmployee_whenFound(){
        assertEquals(12,employeeService.findEmployeeWhoAreNotPilot().size());
    }

//    26. Cho biết mã số của các nhân viên có lương cao nhất.
    @Test
    void testFindEmployeeWithHighestSalary_shouldReturnEmployee_whenFound(){
        assertEquals(289950  ,employeeService.findEmployeeWithHighestSalary().getSalary());
    }

//    27.Cho biết tổng số lương phải trả cho các phi công.
    @Test
    void testFindTotalSalaryHaveToPay_shouldReturnTotalOfSalary_whenFound(){
        assertEquals(2874131,employeeService.findTotalSalaryHaveToPay().getTotalSalary());
    }
}
