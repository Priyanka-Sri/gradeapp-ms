package com.revature.gradingappsubjectms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gradingappsubjectms.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer>{

}
