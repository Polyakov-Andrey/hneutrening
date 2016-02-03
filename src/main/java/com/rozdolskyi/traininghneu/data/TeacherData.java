package com.rozdolskyi.traininghneu.data;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class TeacherData {

	private String id;
	
	@NotEmpty(message = "{error.field.empty}")
	private String name;

	@NotEmpty(message = "{error.field.empty}")
	private String surname;

	@NotEmpty(message = "{error.field.empty}")
	private String patronymic;

	@NotEmpty(message = "{error.field.empty}")
	private String phone;
	
	@Min(message = "{error.field.number.invalid}", value = 0)
	private long experience;
	
	private List<SubjectData> subjects;
	
	private BigDecimal salary;
	
	private int totalHours;
	
	private List<GroupData> relatedGroups;

	
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

	public String getFullName() {
		return name + " " + patronymic + " " + surname ;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<GroupData> getRelatedGroups() {
		return relatedGroups;
	}

	public void setRelatedGroups(List<GroupData> relatedGroups) {
		this.relatedGroups = relatedGroups;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherData other = (TeacherData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
