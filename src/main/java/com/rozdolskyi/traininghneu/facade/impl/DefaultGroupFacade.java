package com.rozdolskyi.traininghneu.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.facade.GroupFacade;
import com.rozdolskyi.traininghneu.model.GroupModel;
import com.rozdolskyi.traininghneu.service.GroupService;

@Component
public class DefaultGroupFacade implements GroupFacade {

	@Autowired
	private GroupService groupService;
	@Autowired
	private Converter<GroupData, GroupModel> groupDataToModelConverter;
	@Autowired
	private Converter<GroupModel, GroupData> groupModelToDataConverter;

	@Override
	public void addGroup(GroupData groupData) {
		GroupModel groupModel = groupDataToModelConverter.convert(groupData);
		groupService.addGroup(groupModel);
	}

	@Override
	public List<GroupData> getGroups() {
		List<GroupData> groupsData = groupService.getGroups().stream().map(groupModelToDataConverter::convert)
				.collect(Collectors.toList());
		return groupsData;
	}

	@Override
	public void removeGroup(String id) {
		groupService.removeGroup(id);
	}

}
