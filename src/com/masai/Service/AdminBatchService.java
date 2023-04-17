package com.masai.Service;

import java.util.Map;

import com.masai.entities.Batch;
import com.masai.exceptions.CourseException;

public class AdminBatchService implements AdminBatch {

	@Override
	public void addBatch(Batch bat, Map<String, Batch> batches) {
		// TODO Auto-generated method stub
		
        batches.put(bat.getBatchName(), bat);
		
//		return "New Batch Added Successfully";
		
		
	}

	@Override
	public String searchBatch(Batch bat, Map<String, Batch> batches) throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateBatch(String bName, Batch bat, Map<String, Batch> batches) throws CourseException {
		// TODO Auto-generated method stub
		
		if(batches != null && batches.size() > 0) {
			if(batches.containsKey(bName)) {
				batches.put(bName, bat);
				return "Details has been successfully updated";
			}
			else {
				throw new CourseException("Batch not found");
			}
		}
		else {
			throw new CourseException("Student list is empty");
		}
		
//		return null;
	}

	
	
}
