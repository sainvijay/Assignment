package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Patient;
import com.assignment.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatient() {
		return patientRepository.findAll();

	}

	public Patient insertPatient(Patient patient) {
		return patientRepository.save(patient);

	}

	public Optional<Patient> getPatientById(String id) {
		return patientRepository.findById(id);

	}

	public void deletePatientById(String id) {
		patientRepository.deleteById(id);

	}

	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);

	}

}
