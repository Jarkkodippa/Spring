package com.springtrain.organizationservice.service.impl;

import com.springtrain.organizationservice.dto.OrganizationDto;
import com.springtrain.organizationservice.entity.Organization;
import com.springtrain.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.springtrain.organizationservice.repository.OrganizationRepository;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    private ModelMapper modelMapper;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
     //   Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization organization = modelMapper.map(organizationDto, Organization.class);

        Organization savedOrganization = organizationRepository.save(organization);

        return modelMapper.map(savedOrganization,OrganizationDto.class);
        //return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        //return OrganizationMapper.mapToOrganizationDto(organization);
        return modelMapper.map(organization,OrganizationDto.class);
    }
}
