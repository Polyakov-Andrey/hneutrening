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
public class TeacherModelToDataConverter implements Converter<TeacherModel, TeacherData> {

	@Autowired
	private Converter<SubjectModel, SubjectData> subjectModelToDataConverter;
	
	public TeacherData convert(TeacherModel teacherModel) {
		TeacherData teacherData = new TeacherData();
		teacherData.setId(teacherModel.getId());
		teacherData.setName(teacherModel.getName());
		teacherData.setSurname(teacherModel.getSurname());
		teacherData.setPatronymic(teacherModel.getPatronymic());
		teacherData.setPhone(teacherModel.getPhone());
		teacherData.setExperience(teacherModel.getExperience());
		List<SubjectData> subjectData = teacherModel.getSubjects().stream()
				.map(subjectModelToDataConverter::convert).collect(Collectors.toList());
		teacherData.setSubjects(subjectData);
		return teacherData;
	}

}
