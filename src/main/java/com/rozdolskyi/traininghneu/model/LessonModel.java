package com.rozdolskyi.traininghneu.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.rozdolskyi.traininghneu.enums.LessonType;

public class LessonModel {

	@Id
	private String id;
	private GroupModel group;
	private TeacherModel teacher;
	private LessonType type;
	private BigDecimal price;
	private SubjectModel subject;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GroupModel getGroup() {
		return group;
	}
	public void setGroup(GroupModel group) {
		this.group = group;
	}
	public TeacherModel getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public SubjectModel getSubject() {
		return subject;
	}
	public void setSubject(SubjectModel subject) {
		this.subject = subject;
	}
	public LessonType getType() {
		return type;
	}
	public void setType(LessonType type) {
		this.type = type;
	}
		
}
