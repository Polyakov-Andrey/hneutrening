package com.rozdolskyi.traininghneu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rozdolskyi.traininghneu.dao.TeacherDao;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Repository
public class DefaultTeacherDao implements TeacherDao{

	@Autowired 
	private MongoOperations mongoOperations;

	@Override
    public void addTeacher(TeacherModel teacherModel) {
        mongoOperations.save(teacherModel);
	}

	@Override
	public List<TeacherModel> getTeachers() {
        mongoOperations.createCollection("teachers");
        mongoOperations.createCollection("lessons");
        mongoOperations.createCollection("subjects");
        mongoOperations.createCollection("groups");
        return mongoOperations.findAll(TeacherModel.class);
	}

	@Override
	public void removeTeacher(String id) {
		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), TeacherModel.class);
	}

	@Override
	public TeacherModel getTeacher(String id) {
		return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), TeacherModel.class);
	}

	@Override
	public void saveTeacher(TeacherModel teacherModel) {
		mongoOperations.save(teacherModel);
	}

}
