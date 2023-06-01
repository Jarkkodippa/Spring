package com.springtrain.departmentservice.service.impl;

import com.springtrain.departmentservice.dto.DepartmentDto;
import com.springtrain.departmentservice.entity.Department;
import com.springtrain.departmentservice.exception.ResourceNotFoundException;
import com.springtrain.departmentservice.repository.DepartmentRepository;
import com.springtrain.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import com.springtrain.departmentservice.mapper.AutoDepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto,Department.class);

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto saveDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(saveDepartment);

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Optional<Department> department = java.util.Optional.ofNullable(departmentRepository.findByDepartmentCode(departmentCode));

        if(!department.isPresent()) {
            throw new ResourceNotFoundException("Department", "code", departmentCode);
        }

        DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);

        return departmentDto;
    }

}
