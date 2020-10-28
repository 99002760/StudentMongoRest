  
package com.studentapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer>{
	
	List<Student> findByName(String name);
	List<Student> findByDept(String dept);

	
}



