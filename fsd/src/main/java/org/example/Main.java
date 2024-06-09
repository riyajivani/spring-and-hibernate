package org.example;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.entities.Employee.class);
        SessionFactory sessionFactory = config.buildSessionFactory();

        EmployeeDAO employeeDAO = new EmployeeDAOImpl(sessionFactory);

        Employee emp1 = new Employee();
        emp1.setEid(1);
        emp1.setEmployeeName("riya");

        Employee emp2 = new Employee();
        emp2.setEid(2);
        emp2.setEmployeeName("Hetvi");
        employeeDAO.saveEmployee(emp1);
        employeeDAO.saveEmployee(emp2);

        List<Employee> employees = employeeDAO.getAllEmployee();

        Employee employeetoUpdate =employeeDAO.getEmployeeById(1);

        if(employeetoUpdate !=null){
            employeetoUpdate.setEmployeeName("priya");
            employeeDAO.updateEmployee(employeetoUpdate);
        }

        Employee updateEmployee = employeeDAO.getEmployeeById(1);

//        employeeDAO.deleteEmployee(2);
//        List<Employee> employeedeleted = employeeDAO.getAllEmployee();
        sessionFactory.close();
    }
}