package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
}
