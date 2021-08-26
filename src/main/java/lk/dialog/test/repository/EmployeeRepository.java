package lk.dialog.test.repository;

import lk.dialog.test.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository {
    Employee save(Employee employee);
    Employee findById(int id);
}
