  
package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;
@RestController
@RequestMapping("/student-api")
public class StudentController {
	@Autowired
	StudentService studentService;
	@PostMapping("/students")
	Student addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
		
	}
	@DeleteMapping("/students/delete-one/{studentId}")
	boolean deleteStudent(@PathVariable("studentId")Integer studentId) throws StudentNotFoundException {
		return studentService.deleteStudent(studentId);
		
	}
	 
	@GetMapping("/students/get-one/{studentId}")
	Student getStudentById(@PathVariable("studentId")Integer studentId) throws StudentNotFoundException  {
		return studentService.getStudentById(studentId);
		
	}
	@PutMapping("/students/update-one")
	Student updateStudent(Student student) {
		return studentService.updateStudent(student);
		
	}
	@GetMapping("/students")
	List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	   @GetMapping("/students/name/{name}")
	    List<Student>getStudentByName(@PathVariable("name")String name) throws StudentNotFoundException{
	        return studentService.getStudentbyName(name);
	    }
	    @GetMapping("/books/dept/{dept}")
	    List<Student>getStudentByDept(@PathVariable("dept")String dept) throws StudentNotFoundException{
	        return studentService.getStudentByDept(dept);
	    }
	    
	  

	 

}