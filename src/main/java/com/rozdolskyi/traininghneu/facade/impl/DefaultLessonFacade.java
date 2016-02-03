package com.rozdolskyi.traininghneu.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.LessonData;
import com.rozdolskyi.traininghneu.facade.LessonFacade;
import com.rozdolskyi.traininghneu.model.LessonModel;
import com.rozdolskyi.traininghneu.service.LessonService;

@Component
public class DefaultLessonFacade implements LessonFacade {

	@Autowired
	private LessonService lessonService;
	@Autowired
	private Converter<LessonData, LessonModel> lessonDataToModelConverter;
	@Autowired
	private Converter<LessonModel, LessonData> lessonModelToDataConverter;

	@Override
	public void addLesson(LessonData lessonData) {
		LessonModel lessonModel = lessonDataToModelConverter.convert(lessonData);
		lessonService.addLesson(lessonModel);
	}

	@Override
	public List<LessonData> getLessons() {
		List<LessonModel> lessonModels = lessonService.getLessons();
		if(lessonModels == null) 
			return java.util.Collections.emptyList();
		return lessonModels.stream()
				.map(lessonModelToDataConverter::convert).collect(Collectors.toList());
	}

	@Override
	public void removeLesson(String id) {
		lessonService.removeLesson(id);
	}

	@Override
	public LessonData getLesson(String id) {
		LessonModel lessonModel = lessonService.getLesson(id);
		return lessonModelToDataConverter.convert(lessonModel);
	}

	@Override
	public void saveLesson(LessonData lessonData) {
		LessonModel lessonModel = lessonDataToModelConverter.convert(lessonData);
		lessonService.saveLesson(lessonModel);
	}

}
