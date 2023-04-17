package com.masai.Service;



import java.util.Map;
import com.masai.entities.Batch;
import com.masai.entities.Course;
import com.masai.exceptions.CourseException;


public interface AdminCourse {
	
	public String addCourse(Course std, Map<String, Course> courses);
	
	public void viewAllCourses(Map<String, Course> courses) throws CourseException;
	
	public void viewAllBatches(Map<String, Batch> batches) throws CourseException;
	
	public void searchCourse(Map<String, Course> courses)  throws CourseException;
	
	public Object updateCourse(String couName, Course std, Map<String, Course> courses)  throws CourseException;
	
	public void deleteProduct(String email, Map<String, Course> products) throws CourseException;
 
}
