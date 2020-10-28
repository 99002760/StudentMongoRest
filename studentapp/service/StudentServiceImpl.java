  
package com.studentapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.dao.StudentRepository;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	
		@Autowired
		StudentRepository studentRepository;


		@Override
		public Student addStudent(Student student) {
			Student newstudent =studentRepository.save(student);
			
			return newstudent;
		}

		@Override
		public boolean deleteStudent(Integer studentId) throws StudentNotFoundException {
			studentRepository.deleteById(studentId);
			return true;
		}

		@Override
		public Student getStudentById(Integer studentId) throws StudentNotFoundException {
			Student student=studentRepository.findById(studentId)
			.orElseThrow(()->new StudentNotFoundException("Id not available"));
			return null;
			
		}      

		@Override
		public Student updateStudent(Student student) {
			
			return studentRepository.save(student);
		}

		@Override
		public List<Student> getAllStudents() {
			
			return studentRepository.findAll();
		}

		@Override
		public List<Student> getStudentbyName(String name) throws StudentNotFoundException {
			// TODO Auto-generated method stub
			return studentRepository.findByName(name);
		}

		@Override
		public List<Student> getStudentByDept(String dept) throws StudentNotFoundException {
			// TODO Auto-generated method stub
			return  studentRepository.findByDept(dept);
			
		}

		
				
}
