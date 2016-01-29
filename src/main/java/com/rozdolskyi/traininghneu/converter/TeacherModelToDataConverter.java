package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Component
public class TeacherModelToDataConverter implements Converter<TeacherModel, TeacherData> {

	public TeacherData convert(TeacherModel teacherModel) {
		TeacherData teacherData = new TeacherData();
		teacherData.setName(teacherModel.getName());
		teacherData.setSurname(teacherModel.getSurname());
		teacherData.setPatronymic(teacherModel.getPatronymic());
		teacherData.setPhone(teacherModel.getPhone());
		teacherData.setExperience(teacherModel.getExperience());
		//teacherData.setSubjects(teacherModel.getSubjects());
		return teacherData;
	}

}
