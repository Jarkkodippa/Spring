package com.springtrain.departmentservice.service.impl;

import com.springtrain.departmentservice.dto.DepartmentDto;
import com.springtrain.departmentservice.entity.Department;
import com.springtrain.departmentservice.repository.DepartmentRepository;
import com.springtrain.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import com.springtrain.departmentservice.mapper.AutoDepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto,Department.class);
/*
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
*/
        Department saveDepartment = departmentRepository.save(department);
/*
        DepartmentDto saveDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );
  */
        DepartmentDto saveDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(saveDepartment);

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
/*
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

 */
        return departmentDto;
    }

}
