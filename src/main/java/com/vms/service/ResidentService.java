package com.vms.service;

import java.util.List;
import java.util.Map;

import com.vms.model.Resident;

public interface ResidentService {

    List<Resident> getAll();

    Resident getById(Long id);

    Resident create(Resident resident);

    Resident update(Long id, Resident resident);

    void delete(Long id);

    Map<String, List<Resident>> getByRole();

    Map<String, List<Resident>> getByRole(String role);
}
