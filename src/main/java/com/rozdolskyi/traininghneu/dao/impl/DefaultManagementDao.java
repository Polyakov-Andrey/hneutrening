package com.rozdolskyi.traininghneu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.rozdolskyi.traininghneu.dao.ManagementDao;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Repository
public class DefaultManagementDao implements ManagementDao{

	@Autowired 
	private MongoOperations mongoOperations;

	public void addTeacher(TeacherModel teacherModel) {
		mongoOperations.save(teacherModel);
	}

	public List<TeacherModel> getTeachers() {
		return mongoOperations.findAll(TeacherModel.class);
	}

	public void addSubject(SubjectModel subjectModel) {
		mongoOperations.save(subjectModel);
	}

	public List<SubjectModel> getSubjects() {
		return mongoOperations.findAll(SubjectModel.class);
	}

}
