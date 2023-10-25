package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {		
		return studentRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student deleteStudent(int id) {
		Student s = studentRepository.findById(id).get();
		studentRepository.deleteById(id);
		return s;
	}

	@Override
	public Student updateStudent(Student student, int id) {
		Student s = studentRepository.findById(id).get();
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		studentRepository.save(s);
		return s;
	}

	@Override
	public Student findById(int id) {
		Student s = studentRepository.findById(id).get();
		return s;
	}
	
	
}
