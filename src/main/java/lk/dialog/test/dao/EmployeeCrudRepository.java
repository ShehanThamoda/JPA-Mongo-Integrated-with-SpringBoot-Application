package lk.dialog.test.dao;

import lk.dialog.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface EmployeeCrudRepository extends JpaRepository<Employee,Integer> {
    Employee findById(int id);
}
