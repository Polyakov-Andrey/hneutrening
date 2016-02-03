package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.GroupModel;

public interface GroupDao {
	
	void addGroup(GroupModel groupModel);

	List<GroupModel> getGroups();

	void removeGroup(String id);

	GroupModel getGroup(String id);

	void saveGroup(GroupModel groupModel);

}
