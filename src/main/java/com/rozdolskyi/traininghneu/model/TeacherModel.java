package com.rozdolskyi.traininghneu.model;

import java.util.List;

public class TeacherModel {
	
	private String name;
	private String surname;
	private String patronymic;
	private String phone;
	private long experience;
	private List<SubjectModel> subjects;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getExperience() {
		return experience;
	}
	public void setExperience(long experience) {
		this.experience = experience;
	}
	public List<SubjectModel> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectModel> subjects) {
		this.subjects = subjects;
	}
	
}
