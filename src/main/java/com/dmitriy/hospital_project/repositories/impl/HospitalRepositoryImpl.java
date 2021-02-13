package com.dmitriy.hospital_project.repositories.impl;

import com.dmitriy.hospital_project.domain.Hospital;
import com.dmitriy.hospital_project.repositories.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
public class HospitalRepositoryImpl implements HospitalRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(HospitalRepositoryImpl.class);
    private static final BeanPropertyRowMapper<Hospital> HOSPITAL_BEAN_PROPERTY_ROW_MAPPER =  new BeanPropertyRowMapper<>(Hospital.class);


    private final JdbcTemplate jdbcTemplate;

    public HospitalRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Hospital> getOne(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM hospitals WHERE id = ?", HOSPITAL_BEAN_PROPERTY_ROW_MAPPER, id));
        } catch(EmptyResultDataAccessException e) {
            LOGGER.debug("No hospitals found with id " + id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Hospital> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM hospitals", HOSPITAL_BEAN_PROPERTY_ROW_MAPPER);
        } catch(DataAccessException e) {
            LOGGER.debug("Method getAll (hospitals table) failed.");
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Hospital> create(Hospital hospital) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO hospitals(name, address, phone, type, use_of_insurance, number_of_doctors) VALUES(?, ?, ?, ?, ?, ?)", new String[] {"id"});
            statement.setString(1, hospital.getName());
            statement.setString(2, hospital.getAddress());
            statement.setString(3, hospital.getPhone());
            statement.setString(4, hospital.getType());
            statement.setBoolean(5, hospital.getUse_of_insurance());
            statement.setLong(6, hospital.getNumber_of_doctors());
            return statement;
        }, keyHolder);
        long hospitalId = keyHolder.getKey().longValue();
        return getOne(hospitalId);
    }

    @Override
    public Optional<Hospital> update(Long id, Hospital hospital) {
        try {
            jdbcTemplate.update("UPDATE hospitals SET name=?, address=?, phone=?, type=?, use_of_insurance=?, number_of_doctors=? " +
                    "WHERE id=?",
                    hospital.getName(), hospital.getAddress(), hospital.getPhone(), hospital.getType(), hospital.getUse_of_insurance(), hospital.getNumber_of_doctors(), id);
            return getOne(id);
        } catch (DataAccessException e) {
            LOGGER.debug("Method update (hospitals table) failed.");
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcTemplate.update("DELETE FROM hospitals WHERE id = ?", id);
        } catch (DataAccessException e) {
            LOGGER.debug("Method delete (hospitals table) failed.");
        }
    }
}
