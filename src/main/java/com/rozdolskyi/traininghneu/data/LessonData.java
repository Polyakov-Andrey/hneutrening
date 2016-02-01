package com.rozdolskyi.traininghneu.data;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.rozdolskyi.traininghneu.enums.LessonType;

public class LessonData {

	@Id
	private String id;
	private GroupData group;
	private TeacherData teacher;
	private LessonType type;
	private BigDecimal price;
	private SubjectData subject;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GroupData getGroup() {
		return group;
	}
	public void setGroup(GroupData group) {
		this.group = group;
	}
	public TeacherData getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherData teacher) {
		this.teacher = teacher;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public SubjectData getSubject() {
		return subject;
	}
	public void setSubject(SubjectData subject) {
		this.subject = subject;
	}
	public LessonType getType() {
		return type;
	}
	public void setType(LessonType type) {
		this.type = type;
	}
		
}
