package com.dmitriy.hospital_project.repositories;

import com.dmitriy.hospital_project.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {

    Optional<Service> getOne(Long id);

    List<Service> getAll();

    List<Service> getAllByHospitalId(Long HospitalId);

    Optional<Service> create(Service service);

    Optional<Service> update(Long id, Service service);

    void delete(Long id);
}
