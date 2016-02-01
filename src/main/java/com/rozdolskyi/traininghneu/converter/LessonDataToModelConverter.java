package com.rozdolskyi.traininghneu.converter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.data.LessonData;
import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.model.GroupModel;
import com.rozdolskyi.traininghneu.model.LessonModel;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;

@Component
public class LessonDataToModelConverter implements Converter<LessonData, LessonModel> {

	@Autowired
	private Converter<GroupData, GroupModel> groupDataToModelConverter;
	
	@Autowired
	private Converter<SubjectData, SubjectModel> subjectDataToModelConverter;
	
	@Autowired
	private Converter<TeacherData, TeacherModel> teacherDataToModelConverter;
	
	
	public LessonModel convert(LessonData lessonData) {
		LessonModel lessonModel = new LessonModel();
		lessonModel.setId(lessonData.getId());
		lessonModel.setGroup(groupDataToModelConverter.convert(lessonData.getGroup()));
		lessonModel.setSubject(subjectDataToModelConverter.convert(lessonData.getSubject()));
		lessonModel.setTeacher(teacherDataToModelConverter.convert(lessonData.getTeacher()));
		lessonModel.setType(lessonData.getType());
		lessonModel.setPrice(BigDecimal.ONE);
		return lessonModel;
	}

}
