package com.rozdolskyi.traininghneu.service;

import java.util.List;

import com.rozdolskyi.traininghneu.model.GroupModel;

public interface GroupService {
	
	void addGroup(GroupModel groupModel);

	List<GroupModel> getGroups();
	
	void removeGroup(String id);

	GroupModel getGroup(String id);

}
