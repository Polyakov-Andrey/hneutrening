package com.rozdolskyi.traininghneu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rozdolskyi.traininghneu.dao.GroupDao;
import com.rozdolskyi.traininghneu.model.GroupModel;

@Repository
public class DefaultGroupDao implements GroupDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void addGroup(GroupModel groupModel) {
		mongoOperations.save(groupModel);
	}

	@Override
	public List<GroupModel> getGroups() {
		return mongoOperations.findAll(GroupModel.class);
	}

	@Override
	public void removeGroup(String id) {
		mongoOperations.remove(Query.query(Criteria.where("id").is(id)), GroupModel.class);
	}

}
