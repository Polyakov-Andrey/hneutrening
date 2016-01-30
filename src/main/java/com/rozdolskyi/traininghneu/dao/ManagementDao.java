package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.TeacherModel;

public interface ManagementDao {

	void addTeacher(TeacherModel teacherModel);
	
	List<TeacherModel> getTeachers();

}
