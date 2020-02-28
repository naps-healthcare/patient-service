package com.redhat.healthcare.patient.dao;

import java.util.List;

import com.redhat.healthcare.patient.domain.Patient;

public interface IPatientDAO {
    
    public List<Patient> getPatients();
    public Patient getPatient(Integer patientId);
    public Integer addPatient(Patient patient);
    public void deletePatient(Integer id);
    public Integer updatePatient(Patient patient);

}