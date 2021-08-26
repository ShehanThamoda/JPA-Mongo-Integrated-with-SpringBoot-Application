package lk.dialog.test.controller;

import io.swagger.annotations.ApiOperation;
import lk.dialog.test.config.LogExecutionTime;
import lk.dialog.test.request.EmployeeAddRequest;
import lk.dialog.test.request.EmployeeUpdateRequest;
import lk.dialog.test.request.UserAddRequest;
import lk.dialog.test.response.EmployeeAddResponse;
import lk.dialog.test.response.UserAddResponse;
import lk.dialog.test.service.RequestService;
import lk.dialog.test.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author shehan
 */
@RestController
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestService requestService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * @des insert the employee records using JPA
     * @param employeeAddRequest
     * @return ResponseEntity<EmployeeAddResponse>
     */
    @ApiOperation(value = "save employee details", notes = "insert employee details")
    @PostMapping(value = "/employee")
    @LogExecutionTime
    public ResponseEntity<EmployeeAddResponse> createEmployee(
            @Valid @RequestBody EmployeeAddRequest employeeAddRequest,@RequestHeader("Authorization") String authHeader) {
        logger.info("START | create employee - Employee: {}", employeeAddRequest.toString());
        EmployeeAddResponse employeeAddResponse = requestService.addEmployeeRecords(employeeAddRequest);
        logger.info("END | create Employee");
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeAddResponse);
    }

    /**
     * @des update the employee records using JPA
     * @param employeeId
     * @param employeeUpdateRequest
     * @param authHeader
     * @return ResponseEntity<EmployeeAddResponse>
     */
    @ApiOperation(value = "update employee details", notes = "update employee details")
    @PutMapping(value = "/employee/{id}")
    @LogExecutionTime
    public ResponseEntity<EmployeeAddResponse> updateEmployee(
            @PathVariable("id") @Min(value = 1,message = "minimum value should be equals to the 1") int employeeId,
            @RequestBody EmployeeUpdateRequest employeeUpdateRequest, @RequestHeader("Authorization") String authHeader) {
        logger.info("START | update employee - Employee: {}", employeeUpdateRequest.toString());
        EmployeeAddResponse employeeAddResponse = requestService.updateEmployeeRecords(employeeId,employeeUpdateRequest);
        logger.info("END | update Employee");
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeAddResponse);
    }

    /**
     * @des insert the user details using mongo db
     * @param userAddRequest
     * @return ResponseEntity<UserAddResponse>
     */
    @ApiOperation(value = "save user details", notes = "insert user details")
    @PostMapping(value = "/users")
    @LogExecutionTime
    public ResponseEntity<UserAddResponse> createUser(
            @Valid @RequestBody UserAddRequest userAddRequest, @RequestHeader("Authorization") String authHeader) {
        logger.info("START | create user - User: {}", userAddRequest.toString());
        UserAddResponse userAddResponse = requestService.addUserRecords(userAddRequest);
        logger.info("END | create user");
        return ResponseEntity.status(HttpStatus.CREATED).body(userAddResponse);
    }
}
