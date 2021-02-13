package com.dmitriy.hospital_project.repositories.impl;

import com.dmitriy.hospital_project.domain.Service;
import com.dmitriy.hospital_project.repositories.ServiceRepository;
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
public class ServiceRepositoryImpl implements ServiceRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRepositoryImpl.class);
    private static final BeanPropertyRowMapper<Service> SERVICE_BEAN_PROPERTY_ROW_MAPPER =  new BeanPropertyRowMapper<>(Service.class);

    private final JdbcTemplate jdbcTemplate;

    public ServiceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Service> getOne(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM services WHERE id = ?", SERVICE_BEAN_PROPERTY_ROW_MAPPER, id));
        } catch(EmptyResultDataAccessException e) {
            LOGGER.debug("No services found with id " + id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Service> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM services", SERVICE_BEAN_PROPERTY_ROW_MAPPER);
        } catch(DataAccessException e) {
            LOGGER.debug("Method getAll (services table) failed.");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Service> getAllByHospitalId(Long HospitalId) {
        try {
            return jdbcTemplate.query("SELECT * FROM services WHERE hospital_id = ?", SERVICE_BEAN_PROPERTY_ROW_MAPPER);
        } catch(DataAccessException e) {
            LOGGER.debug("Method getAllByHospitalId (services table) failed.");
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Service> create(Service service) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO services(name, price, percent_insurance, time, hospital_id) VALUES(?, ?, ?, ?, ?)", new String[] {"id"});
            statement.setString(1, service.getName());
            statement.setLong(2, service.getPrice());
            statement.setLong(3, service.getPercent_insurance());
            statement.setLong(4, service.getTime());
            statement.setLong(5, service.getHospital_id());
            return statement;
        }, keyHolder);
        long hospitalId = keyHolder.getKey().longValue();
        return getOne(hospitalId);
    }

    @Override
    public Optional<Service> update(Long id, Service service) {
        try {
            jdbcTemplate.update("UPDATE services SET name=?, price=?, percent_insurance=?, time=? WHERE id=?",
                    service.getName(), service.getPrice(), service.getPercent_insurance(), service.getTime(), id);
            return getOne(id);
        } catch (DataAccessException e) {
            LOGGER.debug("Method update (services table) failed.");
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcTemplate.update("DELETE FROM services WHERE id = ?", id);
        } catch (DataAccessException e) {
            LOGGER.debug("Method delete (services table) failed.");
        }
    }
}
