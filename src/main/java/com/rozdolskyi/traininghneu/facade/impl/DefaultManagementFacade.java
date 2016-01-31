package com.rozdolskyi.traininghneu.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.ManagementService;

@Component
public class DefaultManagementFacade implements ManagementFacade {

	@Autowired
	private ManagementService managementService;
	@Autowired
	private Converter<TeacherData, TeacherModel> teacherDataToModelConverter;
	@Autowired
	private Converter<SubjectData, SubjectModel> subjectDataToModelConverter;
	@Autowired
	private Converter<TeacherModel, TeacherData> teacherModelToDataConverter;
	@Autowired
	private Converter<SubjectModel, SubjectData> subjectModelToDataConverter;

	@Override
	public void addTeacher(TeacherData teacherData) {
		TeacherModel teacherModel = teacherDataToModelConverter.convert(teacherData);
		managementService.addTeaher(teacherModel);
	}

	@Override
	public void addSubject(SubjectData subjectData) {
		SubjectModel subjectModel = subjectDataToModelConverter.convert(subjectData);
		managementService.addSubject(subjectModel);
	}

	@Override
	public List<TeacherData> getTeachers() {
		List<TeacherData> teacherData = managementService.getTeachers().stream()
				.map(teacherModelToDataConverter::convert).collect(Collectors.toList());
		return teacherData;
	}

	@Override
	public List<SubjectData> getSubjects() {
		List<SubjectData> subjectData = managementService.getSubjects().stream()
				.map(subjectModelToDataConverter::convert).collect(Collectors.toList());
		return subjectData;
	}

	@Override
	public void removeTeacher(String id) {
		managementService.removeTeacher(id);
	}

	@Override
	public void removeSubject(String id) {
		managementService.removeSubject(id);
	}

	@Override
	public TeacherData getTeacher(String id) {
		return teacherModelToDataConverter.convert(managementService.getTeacher(id));
	}

	@Override
	public SubjectData getSubject(String id) {
		return subjectModelToDataConverter.convert(managementService.getSubject(id));
	}

}
