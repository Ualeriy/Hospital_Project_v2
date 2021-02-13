package com.dmitriy.hospital_project.repositories;

import com.dmitriy.hospital_project.domain.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {

    Optional<Hospital> getOne(Long id);

    List<Hospital> getAll();

    Optional<Hospital> create(Hospital hospital);

    Optional<Hospital> update(Long id, Hospital hospital);

    void delete(Long id);
}
