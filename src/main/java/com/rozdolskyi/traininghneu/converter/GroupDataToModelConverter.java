package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.model.GroupModel;

@Component
public class GroupDataToModelConverter implements Converter<GroupData, GroupModel> {

	public GroupModel convert(GroupData groupData) {
		GroupModel groupModel = new GroupModel();
		groupModel.setId(groupData.getId());
		groupModel.setSpeciality(groupData.getSpeciality());
		groupModel.setDepartment(groupData.getDepartment());
		groupModel.setStudentsCount(groupData.getStudentsCount());
		return groupModel;
	}

}
