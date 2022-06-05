package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.service.dto.TotalSalaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    List<Employee> findBySalaryLessThan(Integer minSalary);

    @Query("FROM Employee " +
            "WHERE id NOT IN (SELECT employee.id " +
                            "FROM Certificate)")
    List<Employee> findEmployeeWhoAreNotPilot();

    @Query("FROM Employee " +
            "WHERE salary = (SELECT max(salary) " +
            "FROM Employee)")
    Employee findEmployeeWithHighestSalary();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.TotalSalaryDto(sum(salary)) " +
            "From Employee ")
    TotalSalaryDto FindTotalSalaryHaveToPay();
}
