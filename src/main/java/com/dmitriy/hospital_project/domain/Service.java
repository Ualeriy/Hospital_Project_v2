package com.dmitriy.hospital_project.domain;

import java.util.Objects;

public class Service {
    private Long id;
    private String name;
    private Long price;
    private Long percent_insurance;
    private Long time;
    private Long hospital_id;


    public Service() {
    }

    public Service(String name, Long price, Long percent_insurance, Long time) {
        this.name = name;
        this.price = price;
        this.percent_insurance = percent_insurance;
        this.time = time;
    }

    public Service(String name, Long price, Long percent_insurance, Long time, Long hospital_id) {
        this.name = name;
        this.price = price;
        this.percent_insurance = percent_insurance;
        this.time = time;
        this.hospital_id = hospital_id;
    }

    public Service(Long id, String name, Long price, Long percent_insurance, Long time, Long hospital_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.percent_insurance = percent_insurance;
        this.time = time;
        this.hospital_id = hospital_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPercent_insurance() {
        return percent_insurance;
    }

    public void setPercent_insurance(Long percent_insurance) {
        this.percent_insurance = percent_insurance;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) &&
                Objects.equals(name, service.name) &&
                Objects.equals(price, service.price) &&
                Objects.equals(percent_insurance, service.percent_insurance) &&
                Objects.equals(time, service.time) &&
                Objects.equals(hospital_id, service.hospital_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, percent_insurance, time, hospital_id);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", percent_insurance=" + percent_insurance +
                ", time=" + time +
                ", hospital_id=" + hospital_id +
                '}';
    }
}
