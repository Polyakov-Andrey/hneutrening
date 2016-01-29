package com.rozdolskyi.traininghneu.facade.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.ManagementService;

@Component
public class DefaultManagementFacade implements ManagementFacade{

	@Autowired
	private ManagementService managementService;
	@Resource
	private Converter<TeacherData, TeacherModel> teacherDataToModelConverter;
	
	public void addTeacher(TeacherData teacherData) {
		TeacherModel teacherModel = teacherDataToModelConverter.convert(teacherData);
		managementService.addTeaher(teacherModel);
	}

}
