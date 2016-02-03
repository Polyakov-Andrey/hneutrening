package com.rozdolskyi.traininghneu.service;

import java.util.List;

import com.rozdolskyi.traininghneu.model.TeacherModel;

public interface TeacherService {

	void addTeaher(TeacherModel teacherModel);

	List<TeacherModel> getTeachers();
	
	void removeTeacher(String id);

	TeacherModel getTeacher(String id);

	void saveTeacher(TeacherModel teacherModel);
}
