package lk.dialog.test.repository;

import lk.dialog.test.dao.EmployeeCrudRepository;
import lk.dialog.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeCrudRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeCrudRepository.findById(id);
    }
}
