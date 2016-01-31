package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.model.GroupModel;

@Component
public class GroupModelToDataConverter implements Converter<GroupModel, GroupData> {

	public GroupData convert(GroupModel groupModel) {
		GroupData groupData = new GroupData();
		groupData.setId(groupModel.getId());
		groupData.setSpeciality(groupModel.getSpeciality());
		groupData.setDepartment(groupModel.getDepartment());
		groupData.setStudentsCount(groupModel.getStudentsCount());
		return groupData;
	}

}
