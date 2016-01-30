package com.rozdolskyi.traininghneu.service;

import java.util.List;

import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;

public interface ManagementService {

	void addTeaher(TeacherModel teacherModel);

	List<TeacherModel> getTeachers();
	
	void addSubject(SubjectModel subjectModel);

	List<SubjectModel> getSubjects();
	
}
