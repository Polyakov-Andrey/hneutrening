package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.TeacherModel;

public interface TeacherDao {

    void addTeacher(TeacherModel teacherModel);
	
	List<TeacherModel> getTeachers();

	void removeTeacher(String id);

	TeacherModel getTeacher(String id);

	void saveTeacher(TeacherModel teacherModel);
	
}
