package com.rozdolskyi.traininghneu.facade;

import java.util.List;

import com.rozdolskyi.traininghneu.data.LessonData;

public interface LessonFacade {

	void addLesson(LessonData lessonData);

	List<LessonData> getLessons();

	void removeLesson(String id);

	LessonData getLesson(String id);

	void saveLesson(LessonData lessonData);

}
