package com.rozdolskyi.traininghneu.facade;

import java.util.List;

import com.rozdolskyi.traininghneu.data.GroupData;

public interface GroupFacade {

	void addGroup(GroupData groupData);

	List<GroupData> getGroups();
	
	void removeGroup(String id);
	
	GroupData getGroup(String id);

	void saveGroup(GroupData groupData);
		
}
