package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Component
public class TeacherDataToModelConverter implements Converter<TeacherData, TeacherModel> {

	public TeacherModel convert(TeacherData teacherData) {
		TeacherModel teacherModel = new TeacherModel();
		teacherModel.setName(teacherData.getName());
		teacherModel.setSurname(teacherData.getSurname());
		teacherModel.setPatronymic(teacherData.getPatronymic());
		teacherModel.setPhone(teacherData.getPhone());
		teacherModel.setExperience(teacherData.getExperience());
		//teacherData.setSubjects(teacherModel.getSubjects());
		return teacherModel;
	}

}
