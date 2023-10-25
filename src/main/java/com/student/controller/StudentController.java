package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping("/createStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student s = studentService.addStudent(student);
		return new ResponseEntity<Student>(s, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> s = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(s, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
		Student s1 = studentService.findById(id);
		
		if(s1 == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		else {
			Student s = studentService.updateStudent(student, id);
			return new ResponseEntity<Student>(s, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("deleteStudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		Student s = studentService.deleteStudent(id);
		return new ResponseEntity<Student>(s, HttpStatus.OK); 
	}
	
}
