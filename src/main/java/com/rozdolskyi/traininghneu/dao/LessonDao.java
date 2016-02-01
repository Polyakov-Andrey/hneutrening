package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.LessonModel;

public interface LessonDao {
	
	void addLesson(LessonModel lessonModel);

	List<LessonModel> getLessons();

	void removeLesson(String id);

	LessonModel getLesson(String id);

}
