package com.rozdolskyi.traininghneu.data;

import java.util.List;

public class TeacherData {
	
	private String id;
	private String name;
	private String surname;
	private String patronymic;
	private String phone;
	private long experience;
	private List<SubjectData> subjects;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<SubjectData> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectData> subjects) {
		this.subjects = subjects;
	}
}
