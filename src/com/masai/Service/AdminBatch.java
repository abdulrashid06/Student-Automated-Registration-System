package com.masai.Service;

import java.util.Map;

import com.masai.entities.Batch;
import com.masai.entities.Course;
import com.masai.exceptions.CourseException;

public interface AdminBatch {
	
public void addBatch(Batch bat, Map<String, Batch> batches);
	
	public String searchBatch(Batch bat, Map<String, Batch> batches)  throws CourseException;
	
	public Object updateBatch(String bName, Batch bat, Map<String, Batch> batches)  throws CourseException;
	

}
