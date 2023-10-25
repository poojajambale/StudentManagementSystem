package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public Student addStudent(Student student);
	public Student deleteStudent(int id);
	public Student updateStudent(Student student, int id);
	public Student findById(int id);
}
