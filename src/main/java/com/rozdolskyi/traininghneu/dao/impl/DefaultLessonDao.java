package com.rozdolskyi.traininghneu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rozdolskyi.traininghneu.dao.LessonDao;
import com.rozdolskyi.traininghneu.model.LessonModel;

@Repository
public class DefaultLessonDao implements LessonDao {
	
	@Autowired 
	private MongoOperations mongoOperations;

	@Override
	public void addLesson(LessonModel lessonModel) {
		mongoOperations.save(lessonModel);
	}

	@Override
	public List<LessonModel> getLessons() {
		return mongoOperations.findAll(LessonModel.class);
	}

	@Override
	public void removeLesson(String id) {
		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), LessonModel.class);
	}

	@Override
	public LessonModel getLesson(String id) {
		return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), LessonModel.class);
	}

}
