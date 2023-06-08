package com.springtrain.employeeservice.service;

import com.springtrain.employeeservice.dto.APIResponseDto;
import com.springtrain.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
