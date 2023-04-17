package com.masai.Service;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.StudentNotFoundException;

public class StudentServices implements StudentSE {

	@Override
	public boolean login(String email, String password, Map<String, Student> students) throws InvalidDetailsException {


       if (students.containsKey(email) ) {
			
			if(students.get(email).getPassword().equals(password)) {
				return true;
			   }
			   else {
				  throw new InvalidDetailsException("Invalid Credentials");
			   }
			
		   } else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
		
	}

	@Override
	public void signUp(Student stu, Map<String, Student> students) throws DuplicateDataException {


		if (students.containsKey(stu.getEmail())) {
			throw new DuplicateDataException("Student already exists , please login");
		} else {

			students.put(stu.getEmail(), stu);
            
		}
		
	}

//	public static String updatePersonalDetails(Student stu, Map<String, Student> students) throws  DuplicateDataException {
//		// TODO Auto-generated method stub
//		
////		if (students.containsKey(stu.getEmail())) {
////			
////			
////			
////		} else {
////
////			throw new DuplicateDataException("Student already exists , please login");
////
////		}
//		
//	}

	

	

	@Override
	public void ViewCoursesList(Map<String, Course> courses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBatchList(Map<String, Course> courses) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerInCourse(Student stu, Map<String, Course> courses) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object updatePersonalDetails(String email, Student stu, Map<String, Student> students) throws  StubNotFoundException {
		// TODO Auto-generated method stub
		
		if(students != null && students.size() > 0) {
			
//			System.out.print("11111");
			
			if(students.containsKey(email)) {
//				System.out.print("updates");
	        	   students.put(email, stu);
	        	  return "Details has been successfully updated";
	           }
			else {
				throw new StubNotFoundException("Student not found");
			}
		}else {
			throw new StubNotFoundException("Student list is empty");
		}
		
           
		
	}
	
	
	@Override
	public List<Student> viewAllStudents(Map<String, Student> students) throws  StubNotFoundException {

         List<Student> list = null;
         
         if(students != null && students.size() > 0) {
        	 Collection<Student> coll = students.values();
        	 list = new ArrayList<>(coll);
         }
         else {
        	 throw new StubNotFoundException("Student list is Empty");
         }
         
         return list;
		
	}

//	@Override
//	public void changePassword(Student stu, Map<String, Student> students) throws InvalidDetailsException {
//		// TODO Auto-generated method stub
//		
//	}

}
