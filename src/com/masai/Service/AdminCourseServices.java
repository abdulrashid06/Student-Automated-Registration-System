package com.masai.Service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.masai.entities.Batch;
import com.masai.entities.Course;
import com.masai.exceptions.CourseException;



public class AdminCourseServices implements AdminCourse{

	@Override
	public String addCourse(Course std, Map<String, Course> courses) {
		// TODO Auto-generated method stub
		courses.put(std.getName(), std);
		
		return "New Course Added Successfully";
	}
	
	
	
	
	
	
	

	@Override
	public void searchCourse(Map<String, Course> courses) throws CourseException {
		// TODO Auto-generated method stub
		
		List<Course> list = null;
		
		if(courses != null && courses.size() > 0) {
			Collection<Course> coll = courses.values();
			list = new ArrayList<>(coll);
			System.out.println(list);
		}
		else {
			throw new CourseException("Course list is empty");
		}
		
		
//		return list;
	}
	
	
	
	
	
	
	

	@Override
	public Object updateCourse(String couName, Course std, Map<String, Course> courses) throws CourseException {
		// TODO Auto-generated method stub
		
         if(courses != null && courses.size() > 0) {
			
//			System.out.print("11111");
			
			if(courses.containsKey(couName)) {
//				System.out.print("updates");
				courses.put(couName, std);
	        	  return "Details has been successfully updated";
	           }
			else {
				throw new CourseException("Student not found");
			}
		}else {
			throw new CourseException("Student list is empty");
		}

	}

	
	
//	@Override
//	public void addBatch(List<Batch> batches, Batch bat) {
//		// TODO Auto-generated method stub
//		
//		batches.add(bat);
//		
////		return "Batch Added Successfully";
//	}


//	@Override
//	public void viewAllCourses(Map<String, Course> courses) throws CourseException {
//		// TODO Auto-generated method stub
//		
//		if (courses != null && courses.size() > 0) {
//			for (Map.Entry<String, Course> me : courses.entrySet()) {
//				System.out.println(me.getValue());
//			}
//
//		} else {
//			throw new CourseException("Product List is empty");
//		}
//		
//	}
	
	
	
	
	
	

	@Override
	public void viewAllCourses(Map<String, Course> courses) throws CourseException {
		// TODO Auto-generated method stub
		
		if (courses != null && courses.size() > 0) {
			for (Map.Entry<String, Course> me : courses.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new CourseException("Course List is empty");
		}
		
	}

	
	
	
	
	
	
	
	
	@Override
	public void viewAllBatches(Map<String, Batch> batches) throws CourseException {
		// TODO Auto-generated method stub
		
		if (batches != null && batches.size() > 0) {
			for (Map.Entry<String, Batch> me : batches.entrySet()) {
				System.out.println(me.getValue());
			}

		} else {
			throw new CourseException("Batch List is empty");
		}
		
	}
	
	
	
	
	
	

	@Override
	public void deleteProduct(String email, Map<String, Course> courses) throws CourseException {
		// TODO Auto-generated method stub
		
		
		if (courses != null && courses.size() > 0) {

			if (courses.containsKey(email)) {
				courses.remove(email);
				System.out.println("Course deleted successfully");

			} else {
				throw new CourseException("Course not found");
			}

		} else {
			throw new CourseException("Course list is empty");
		}

		
		
	}

	

	

	

}
