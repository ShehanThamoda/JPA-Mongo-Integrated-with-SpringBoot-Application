package lk.dialog.test.service;

import lk.dialog.test.entity.Employee;
import lk.dialog.test.entity.mongo.User;
import lk.dialog.test.repository.EmployeeRepository;
import lk.dialog.test.repository.mongo.UserRepo;
import lk.dialog.test.request.EmployeeAddRequest;
import lk.dialog.test.request.EmployeeUpdateRequest;
import lk.dialog.test.request.UserAddRequest;
import lk.dialog.test.response.EmployeeAddResponse;
import lk.dialog.test.response.UserAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepo userRepo;

    /**
     * @des insert employee records to the Employee tbl
     * @param employeeAddRequest
     * @return EmployeeAddResponse
     */
    public EmployeeAddResponse addEmployeeRecords(EmployeeAddRequest employeeAddRequest){
        EmployeeAddResponse employeeAddResponse = new EmployeeAddResponse();

        Employee employee = new Employee();
        employee.setName(employeeAddRequest.getName());
        employee = employeeRepository.save(employee);
        employeeAddResponse.setId(employee.getId());
        return employeeAddResponse;
    }

    public EmployeeAddResponse updateEmployeeRecords(int id,EmployeeUpdateRequest employeeAddRequest){
        EmployeeAddResponse employeeAddResponse = new EmployeeAddResponse();
        Employee employee = employeeRepository.findById(id);
        if(employee!=null){
            employee.setName(employeeAddRequest.getName());
            employee = employeeRepository.save(employee);
        }
        employeeAddResponse.setId(employee.getId());
        return employeeAddResponse;
    }

    public UserAddResponse addUserRecords(UserAddRequest userAddRequest){
        UserAddResponse userAddResponse = new UserAddResponse();
        User user = new User();
        user.setName(userAddRequest.getName());
        user.setAge(userAddRequest.getAge());
        user = userRepo.save(user);
        userAddResponse.setId(user.getId());
        return userAddResponse;
    }

}
