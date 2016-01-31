package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;

public interface TeacherDao {

	void addTeacher(TeacherModel teacherModel);
	
	List<TeacherModel> getTeachers();

	void addSubject(SubjectModel subjectModel);
	
	List<SubjectModel> getSubjects();

	void removeTeacher(String id);

	void removeSubject(String id);
	
	TeacherModel getTeacher(String id);
	
	SubjectModel getSubject(String id);

}
