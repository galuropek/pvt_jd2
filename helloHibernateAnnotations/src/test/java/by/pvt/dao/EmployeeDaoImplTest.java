package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Department;
import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoImplTest {

    DaoImpl<Employee> employeeDao;

    @Before
    public void setUp() {
        employeeDao = new DaoImpl<>(Employee.class);
    }

    @Test
    public void step1_createEmployee() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Name1");
        employee1.setLastName("LastName1");
        employee1.setCellPhone("111-11-11");

        Employee employee2 = new Employee();
        employee2.setFirstName("Name2");
        employee2.setLastName("LastName2");
        employee2.setCellPhone("222-22-22");

        Employee employee3 = new Employee();
        employee3.setFirstName("Name3");
        employee3.setLastName("LastName3");
        employee3.setCellPhone("333-33-33");

        Department department1 = new Department();
        department1.setDepartmentName("Department1");
        department1.setEmployees(Set.of(employee2, employee1));
        employee1.setDepartment(department1);
        employee2.setDepartment(department1);

        Department department2 = new Department();
        department2.setDepartmentName("Department2");
        department2.setEmployees(Set.of(employee3));
        employee3.setDepartment(department2);

        EmployeeDetails employeeDetails1 = new EmployeeDetails();
        Address address1 = new Address("Minsk", "Lenina", "1", 101);
        address1.setOfficeNumber("101");
        employeeDetails1.setAddress(address1);
        employeeDetails1.setPosition("employee1");
        employeeDetails1.setPrivateNr("e1");
        employeeDetails1.setEmployee(employee1);
        employee1.setEmployeeDetails(employeeDetails1);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setAddress(new Address("Mogilev", "Lenina", "2", 10));
        employeeDetails2.setPosition("employee2");
        employeeDetails2.setPrivateNr("e2");
        employeeDetails2.setEmployee(employee2);
        employee2.setEmployeeDetails(employeeDetails2);

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        employeeDetails3.setAddress(new Address("Mogilev", "Lenina", "3", 10));
        employeeDetails3.setPosition("employee3");
        employeeDetails3.setPrivateNr("e3");
        employeeDetails3.setEmployee(employee3);
        employee3.setEmployeeDetails(employeeDetails3);

        employeeDao.saveOrUpdate(employee1);
        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);

        assertTrue(employee1.getId() == 1);
        assertTrue(employee2.getId() == 2);
        assertTrue(employee3.getId() == 3);
    }


//    @Test
//    public void step3_deleteEmployee() {
//        employeeDao.delete(1L);
//        employeeDao.delete(2L);
//        employeeDao.delete(3L);
//    }

    @After
    public void tearDown() {
//        employeeDao.isTestInstance = false;
        employeeDao = null;
    }

}
