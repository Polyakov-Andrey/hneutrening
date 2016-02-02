package com.rozdolskyi.traininghneu.data;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class GroupData {

	private String id;
	
	@NotEmpty(message = "{error.field.empty}")
	private String speciality;
	
	@NotEmpty(message = "{error.field.empty}")
	private String department;
	
	@Min(message = "{error.field.number.invalid}", value = 0)
	private int studentsCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getStudentsCount() {
		return studentsCount;
	}
	public void setStudentsCount(int studentsCount) {
		this.studentsCount = studentsCount;
	}
	
}
