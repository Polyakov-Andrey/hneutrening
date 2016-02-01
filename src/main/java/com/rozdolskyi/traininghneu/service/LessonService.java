package com.rozdolskyi.traininghneu.service;

import java.util.List;

import com.rozdolskyi.traininghneu.model.LessonModel;

public interface LessonService {

	void addLesson(LessonModel lessonModel);

	List<LessonModel> getLessons();

	void removeLesson(String id);

	LessonModel getLesson(String id);
	
}
