package org.example.dao;

import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private final SessionFactory sessionFactory;
    public EmployeeDAOImpl(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}
    @Override
    public void saveEmployee(Employee employee) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Employee.class,id);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try(Session session = sessionFactory.openSession()){
            Query<Employee> query = session.createQuery("FROM Employee ",Employee.class);
            return query.list();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Employee existingEmployee= session.get(Employee.class,employee.getEid());
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(long id) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class,id);
            if(employee!=null){
                session.remove(employee);
            }
            transaction.commit();
        }
    }
}
