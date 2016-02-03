package com.rozdolskyi.traininghneu.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.model.GroupModel;
import com.rozdolskyi.traininghneu.model.LessonModel;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.LessonService;

@Component
public class TeacherModelToDataConverter implements Converter<TeacherModel, TeacherData> {

	@Autowired
	private Converter<SubjectModel, SubjectData> subjectModelToDataConverter;

	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private Converter<GroupModel, GroupData> groupModelToDataConverter;

	public TeacherData convert(TeacherModel teacherModel) {
		TeacherData teacherData = new TeacherData();
		teacherData.setId(teacherModel.getId());
		teacherData.setName(teacherModel.getName());
		teacherData.setSurname(teacherModel.getSurname());
		teacherData.setPatronymic(teacherModel.getPatronymic());
		teacherData.setPhone(teacherModel.getPhone());
		teacherData.setExperience(teacherModel.getExperience());
		if (teacherModel.getSubjects() != null) {
			List<SubjectData> subjectData = teacherModel.getSubjects()
					.stream().map(subjectModelToDataConverter::convert).collect(Collectors.toList());
			teacherData.setSubjects(subjectData);
		}
		
		List<LessonModel> teacherLessons = lessonService.getLessons().stream()
				.filter(lesson -> lesson.getTeacher().getId().equals(teacherData.getId())).collect(Collectors.toList());
		double salary = teacherLessons.stream().map(LessonModel::getPrice).mapToDouble(BigDecimal::doubleValue).sum();
		teacherData.setSalary(BigDecimal.valueOf(salary).setScale(2, RoundingMode.UP));
		teacherData.setTotalHours(teacherLessons.size());
		
		List<GroupData> teacherGroups = teacherLessons.stream().map(LessonModel::getGroup)
				.map(groupModelToDataConverter::convert).distinct().collect(Collectors.toList());
		teacherGroups.forEach(group -> group.setTotalHoursForTeacher(teacherLessons.stream()
				.map(LessonModel::getGroup).map(GroupModel::getId).filter(group.getId()::equals).count()));
		teacherData.setRelatedGroups(teacherGroups);
		
		return teacherData;
	}

}
