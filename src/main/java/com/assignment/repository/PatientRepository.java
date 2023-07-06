package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
