package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	boolean deleteStudent(Integer studentId) throws StudentNotFoundException;
	Student getStudentById(Integer studentid)throws StudentNotFoundException;
	Student updateStudent(Student student);
	
	List<Student> getAllStudents();
	List<Student> getStudentbyName(String name) throws StudentNotFoundException;;
    List<Student> getStudentByDept(String dept)throws StudentNotFoundException;;
    
    

}