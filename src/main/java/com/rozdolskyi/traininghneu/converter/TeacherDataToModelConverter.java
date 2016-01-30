package com.rozdolskyi.traininghneu.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Component
public class TeacherDataToModelConverter implements Converter<TeacherData, TeacherModel> {

	@Autowired
	private Converter<SubjectData, SubjectModel> subjectDataToModelConverter;
	
	public TeacherModel convert(TeacherData teacherData) {
		TeacherModel teacherModel = new TeacherModel();
		teacherModel.setId(teacherData.getId());
		teacherModel.setName(teacherData.getName());
		teacherModel.setSurname(teacherData.getSurname());
		teacherModel.setPatronymic(teacherData.getPatronymic());
		teacherModel.setPhone(teacherData.getPhone());
		teacherModel.setExperience(teacherData.getExperience());
		List<SubjectModel> subjectModels = teacherData.getSubjects().stream()
				.map(subjectDataToModelConverter::convert).collect(Collectors.toList());
		teacherModel.setSubjects(subjectModels);
		return teacherModel;
	}

}
