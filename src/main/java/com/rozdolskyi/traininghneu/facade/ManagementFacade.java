package com.rozdolskyi.traininghneu.facade;

import java.util.List;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;

public interface ManagementFacade {

	void addTeacher(TeacherData teacherData);

	List<TeacherData> getTeachers();
	
	void addSubject(SubjectData subject);

	List<SubjectData> getSubjects();

	void removeTeacher(String id);
	
	void removeSubject(String id);
	
	TeacherData getTeacher(String id);
	
	SubjectData getSubject(String id);
	
}
