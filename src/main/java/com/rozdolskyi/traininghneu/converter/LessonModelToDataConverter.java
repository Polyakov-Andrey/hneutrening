package com.rozdolskyi.traininghneu.converter;

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
public class LessonModelToDataConverter implements Converter<LessonModel, LessonData> {

	@Autowired
	private Converter<GroupModel, GroupData> groupModelToDataConverter;
	
	@Autowired
	private Converter<SubjectModel, SubjectData> subjectModelToDataConverter;
	
	@Autowired
	private Converter<TeacherModel, TeacherData> teacherModelToDataConverter;
	
	
	public LessonData convert(LessonModel lessonModel) {
		LessonData lessonData = new LessonData();
		lessonData.setId(lessonModel.getId());
		lessonData.setGroup(groupModelToDataConverter.convert(lessonModel.getGroup()));
		lessonData.setSubject(subjectModelToDataConverter.convert(lessonModel.getSubject()));
		lessonData.setTeacher(teacherModelToDataConverter.convert(lessonModel.getTeacher()));
		lessonData.setType(lessonModel.getType());
		lessonData.setPrice(lessonModel.getPrice());
		return lessonData;
	}

}
