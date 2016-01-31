package com.rozdolskyi.traininghneu.model;

import org.springframework.data.annotation.Id;

public class GroupModel {

	@Id
	private String id;
	private String speciality;
	private String department;
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
