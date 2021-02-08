package com.dmitriy.hospital_project.domain;

import java.util.Objects;

public class Hospital {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String type;
    private Boolean use_of_insurance;
    private Long number_of_doctor;


    public Hospital() {
    }

    public Hospital(String name, String address, String phone, String type, Boolean use_of_insurance, Long number_of_doctor) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.use_of_insurance = use_of_insurance;
        this.number_of_doctor = number_of_doctor;
    }

    public Hospital(Long id, String name, String address, String phone, String type, Boolean use_of_insurance, Long number_of_doctor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.use_of_insurance = use_of_insurance;
        this.number_of_doctor = number_of_doctor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getUse_of_insurance() {
        return use_of_insurance;
    }

    public void setUse_of_insurance(Boolean use_of_insurance) {
        this.use_of_insurance = use_of_insurance;
    }

    public Long getNumber_of_doctor() {
        return number_of_doctor;
    }

    public void setNumber_of_doctor(Long number_of_doctor) {
        this.number_of_doctor = number_of_doctor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(id, hospital.id) &&
                Objects.equals(name, hospital.name) &&
                Objects.equals(address, hospital.address) &&
                Objects.equals(phone, hospital.phone) &&
                Objects.equals(type, hospital.type) &&
                Objects.equals(use_of_insurance, hospital.use_of_insurance) &&
                Objects.equals(number_of_doctor, hospital.number_of_doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, type, use_of_insurance, number_of_doctor);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", use_of_insurance=" + use_of_insurance +
                ", number_of_doctor=" + number_of_doctor +
                '}';
    }
}
