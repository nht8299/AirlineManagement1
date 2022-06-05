package com.axonactive.homeSpringBoot.service.Impl;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.EmployeeRepository;
import com.axonactive.homeSpringBoot.service.EmployeeService;
import com.axonactive.homeSpringBoot.service.dto.TotalSalaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findEmployeeWhoAreNotPilot() {
        return employeeRepository.findEmployeeWhoAreNotPilot();
    }

    @Override
    public Employee findEmployeeWithHighestSalary() {
        return employeeRepository.findEmployeeWithHighestSalary();
    }

    @Override
    public TotalSalaryDto findTotalSalaryHaveToPay() {
        return employeeRepository.FindTotalSalaryHaveToPay();
    }
}
