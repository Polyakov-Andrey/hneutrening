package com.rozdolskyi.traininghneu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rozdolskyi.traininghneu.dao.SubjectDao;
import com.rozdolskyi.traininghneu.model.SubjectModel;

@Repository
public class DefaultSubjectDao implements SubjectDao {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void addSubject(SubjectModel subjectModel) {
		mongoOperations.save(subjectModel);
	}

	@Override
	public List<SubjectModel> getSubjects() {
		return mongoOperations.findAll(SubjectModel.class);
	}

	@Override
	public void removeSubject(String id) {
		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), SubjectModel.class);
	}

	@Override
	public SubjectModel getSubject(String id) {
		return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), SubjectModel.class);
	}

}
