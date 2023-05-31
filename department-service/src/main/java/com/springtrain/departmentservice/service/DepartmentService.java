package com.springtrain.departmentservice.service;

import com.springtrain.departmentservice.dto.DepartmentDto;


public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
