package com.redhat.healthcare.patient.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

import com.redhat.healthcare.patient.domain.Patient;

@ApplicationScoped
public class PanachePersonDAO implements IPatientDAO{

    public PanachePersonDAO() {}

	public List<Patient> getPatients() {
		return Patient.listAll();
    }
    
    public Patient getPatient(Integer patientId) {
        Optional<Patient> optional = Patient.findByIdOptional(patientId);
		return optional.orElseThrow(() -> new NotFoundException());
	}

	public Integer addPatient(Patient patient) {
        patient.persistAndFlush();
        return patient.getId();
	}

	public Integer deletePatient(Patient patient) {
		patient.delete();
		return patient.getId();
	}
    
}