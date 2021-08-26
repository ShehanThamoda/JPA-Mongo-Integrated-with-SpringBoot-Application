package lk.dialog.test.dao;

import lk.dialog.test.entity.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Date;

public class EmployeeCrudRepositoryTest{

    EmployeeCrudRepository employeeCrudRepository;
    Employee employee;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetName(){
        employee = Mockito.mock(Employee.class);
        Mockito.when(employee.getName()).thenReturn("Shehan");
        Assert.assertEquals(employee.getName(),"Shehan");
    }

    @Test
    public void testFindByIdEmployee(){
      employee = new Employee(2,"Shehan",new Date(),new Date(),"Shehan","Anuja");

      employeeCrudRepository = Mockito.mock(EmployeeCrudRepository.class);
      Mockito.when(employeeCrudRepository.findById(2)).thenReturn(employee);

      Assertions.assertEquals(employeeCrudRepository.findById(2).getName(),"Shehan");
    }

    @Test
    public void testSaveEmployee(){
        employee = new Employee(2,"Shehan",new Date(),new Date(),"Shehan","Anuja");

        employeeCrudRepository = Mockito.mock(EmployeeCrudRepository.class);
        Mockito.when(employeeCrudRepository.save(employee)).thenReturn(employee);

        Assertions.assertEquals(employeeCrudRepository.save(employee).getId(),2);
    }



}
