package com.sda.model;

import javax.persistence.*;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    //lipseste strategy = GenerationType.IDENTITY si creaza inca un table...
    @GeneratedValue
    private Long doctor_id;

    @Column(name = "doctor_name", length = 40)
    private String doctorName;

    @ManyToOne
    @JoinColumn(name = "hospitalid")
    private Hospital hospital;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
