package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.dto.TotalSalaryDto;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployeeWhoAreNotPilot();

    Employee findEmployeeWithHighestSalary();

    TotalSalaryDto findTotalSalaryHaveToPay();
}
