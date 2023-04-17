package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Batch implements Serializable {
	
	private String batchName;
    private String startDate;
	private String endDate;
	
	
	public Batch(String batchName, String startDate, String endDate) {
		super();
		this.batchName = batchName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public void getBatches() {
		System.out.print("[batchName=" + getBatchName() + ", startDate=" + getStartDate() + ", endDate=" + getEndDate() + "]");
	}
	
	
	
	
	public String getBatchName() {
		return batchName;
	}
	
	
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	public String getEndDate() {
		return endDate;
	}
	
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(batchName, endDate, startDate);
	}
	
	
	
	
	@Override
	public String toString() {
		return " [batchName=" + batchName + ", startDate=" + startDate + ", endDate=" + endDate + "] ";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		return Objects.equals(batchName, other.batchName) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(startDate, other.startDate);
	}
	

}
