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

	private long totalHoursForTeacher;

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

	public long getTotalHoursForTeacher() {
		return totalHoursForTeacher;
	}

	public void setTotalHoursForTeacher(long totalHoursForTeacher) {
		this.totalHoursForTeacher = totalHoursForTeacher;
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
		GroupData other = (GroupData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
