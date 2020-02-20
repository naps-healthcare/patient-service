package com.redhat.healthcare.patient.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Patient extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "patientSequence",
            sequenceName = "patient_seq",
            allocationSize = 1,
            initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientSequence")
    public Integer id;

    public String patientFullName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientFullName() {
		return this.patientFullName;
	}

	public void setPatientFullName(String name) {
		this.patientFullName = name;
	}

}
