package com.vms.service;

import com.vms.dto.ResidentDto;

import java.util.List;
import java.util.Map;


public interface ResidentService {

    List<ResidentDto> getAll();

    ResidentDto getById(Long id);

    ResidentDto create(ResidentDto resident);

    ResidentDto update(Long id, ResidentDto resident);

    void delete(Long id);

    Map<String, List<ResidentDto>> getByRole();

    Map<String, List<ResidentDto>> getByRole(String role);

    void validatePhoneNumber(String phoneNumber);
}
