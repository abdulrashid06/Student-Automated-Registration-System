package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course  implements Serializable{
	
	private String name;
    private int duration;
    private double fee;
    private List<Batch> batches;
    
    
	public Course(String name, int duration, double fee) {
		this.name = name;
		this.duration = duration;
		this.fee = fee;
		this.batches = new ArrayList<>();
	}


	
	
	public void addBatch(Batch bat) {
		this.batches.add(bat);
	}
	
	public void removeBatch(Batch bat) {
		this.batches.remove(bat);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}


	

	@Override
	public String toString() {
		return " [name=" + name + ", duration=" + duration + ", fee=" + fee + ", batches=" + batches + "]";
	}





	@Override
	public int hashCode() {
		return Objects.hash(duration, fee, name);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return duration == other.duration && Double.doubleToLongBits(fee) == Double.doubleToLongBits(other.fee)
				&& Objects.equals(name, other.name);
	}


}
