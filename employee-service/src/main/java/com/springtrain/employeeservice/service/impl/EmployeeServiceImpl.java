package com.springtrain.employeeservice.service.impl;

import com.springtrain.employeeservice.dto.EmployeeDto;
import com.springtrain.employeeservice.entity.Employee;
import com.springtrain.employeeservice.exception.ResourceNotFoundException;
import com.springtrain.employeeservice.mapper.AutoEmployeeMapper;
import com.springtrain.employeeservice.repository.EmployeeRepository;
import com.springtrain.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", employeeId));

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
