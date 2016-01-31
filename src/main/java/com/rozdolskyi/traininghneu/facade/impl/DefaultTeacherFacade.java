package com.rozdolskyi.traininghneu.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.facade.TeacherFacade;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.TeacherService;

@Component
public class DefaultTeacherFacade implements TeacherFacade {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private Converter<TeacherData, TeacherModel> teacherDataToModelConverter;
	@Autowired
	private Converter<TeacherModel, TeacherData> teacherModelToDataConverter;
	
	@Override
	public void addTeacher(TeacherData teacherData) {
		TeacherModel teacherModel = teacherDataToModelConverter.convert(teacherData);
		teacherService.addTeaher(teacherModel);
	}

	@Override
	public List<TeacherData> getTeachers() {
		List<TeacherData> teacherData = teacherService.getTeachers().stream()
				.map(teacherModelToDataConverter::convert).collect(Collectors.toList());
		return teacherData;
	}

	@Override
	public void removeTeacher(String id) {
		teacherService.removeTeacher(id);
	}

	@Override
	public TeacherData getTeacher(String id) {
		return teacherModelToDataConverter.convert(teacherService.getTeacher(id));
	}

}
