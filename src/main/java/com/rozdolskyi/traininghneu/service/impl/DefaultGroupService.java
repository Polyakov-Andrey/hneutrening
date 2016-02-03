package com.rozdolskyi.traininghneu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.GroupDao;
import com.rozdolskyi.traininghneu.model.GroupModel;
import com.rozdolskyi.traininghneu.service.GroupService;

@Service
public class DefaultGroupService implements GroupService {

	@Autowired
	private GroupDao groupDao;
	
	@Override
	public void addGroup(GroupModel groupModel) {
		groupDao.addGroup(groupModel);
	}

	@Override
	public List<GroupModel> getGroups() {
		return groupDao.getGroups();
	}

	@Override
	public void removeGroup(String id) {
		groupDao.removeGroup(id);
	}

	@Override
	public GroupModel getGroup(String id) {
		return groupDao.getGroup(id);
	}

	@Override
	public void saveGroup(GroupModel groupModel) {
		groupDao.saveGroup(groupModel);
	}

}
