package com.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Patient;
import com.assignment.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllPatient() {
		List<Patient> allPatients = patientService.getAllPatient();
		if (allPatients != null)
			return new ResponseEntity<>(allPatients, HttpStatus.OK);
		return new ResponseEntity<>("Data not Found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/save")
	public ResponseEntity<Patient> insertPatient(@RequestBody Patient patient) {
		Patient savePatient = patientService.insertPatient(patient);
		return new ResponseEntity<>(savePatient, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getPatientById(@PathVariable("id") String id) {
		Optional<Patient> patient = patientService.getPatientById(id);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePatientById(@PathVariable("id") String id) {
		patientService.deletePatientById(id);
		return new ResponseEntity<>("Deleted Suucessfully!", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient) {
		patientService.updatePatient(patient);
		return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
	}
}
