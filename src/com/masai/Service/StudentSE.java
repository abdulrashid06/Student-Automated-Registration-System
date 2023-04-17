package com.masai.Service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Map;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

public interface StudentSE {
	
	public boolean login(String email,String password, Map<String, Student> students) throws InvalidDetailsException;

	public void signUp(Student stu, Map<String, Student> students) throws DuplicateDataException;
	
	public Object updatePersonalDetails(String email, Student stu, Map<String, Student> students) throws StubNotFoundException;
	
//	public void changePassword(Student stu, Map<String, Student> students) throws InvalidDetailsException;
	
	public void ViewCoursesList(Map<String, Course> courses);
	
	public void viewBatchList(Map<String, Course> courses) throws InvalidDetailsException;
	
	public void registerInCourse(Student stu, Map<String, Course> courses) throws InvalidDetailsException;
	
	public List<Student> viewAllStudents(Map<String, Student> students) throws StubNotFoundException;

}
