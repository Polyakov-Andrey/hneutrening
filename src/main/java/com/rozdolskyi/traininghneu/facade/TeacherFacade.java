package com.rozdolskyi.traininghneu.facade;

import java.util.List;

import com.rozdolskyi.traininghneu.data.TeacherData;

public interface TeacherFacade {

	void addTeacher(TeacherData teacherData);

	List<TeacherData> getTeachers();

	void removeTeacher(String id);

	TeacherData getTeacher(String id);

	void saveTeacher(TeacherData teacherData);

}
