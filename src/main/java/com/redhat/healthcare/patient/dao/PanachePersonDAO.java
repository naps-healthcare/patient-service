package com.redhat.healthcare.patient.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
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

	public void deletePatient(Integer id) {
		Patient patient = this.getPatient(id);
		patient.delete();
	}

	public Integer updatePatient(Patient patient) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("patientFullName", patient.getPatientFullName());
		params.put("id", patient.getId());
		return Patient.update("patientFullName = :patientFullName where id = :id", params);
	}
    
}