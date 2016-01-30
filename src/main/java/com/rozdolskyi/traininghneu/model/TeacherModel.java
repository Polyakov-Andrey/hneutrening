package com.rozdolskyi.traininghneu.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = TeacherModel.TYPE_CODE)
public class TeacherModel {
	
	protected static final String TYPE_CODE = "teachers";
	
	@Id
	private String id;
	private String name;
	private String surname;
	private String patronymic;
	private String phone;
	private long experience;
	private List<SubjectModel> subjects;
	
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
	public List<SubjectModel> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectModel> subjects) {
		this.subjects = subjects;
	}
	
}
