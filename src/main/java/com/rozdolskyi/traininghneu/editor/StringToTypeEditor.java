package com.rozdolskyi.traininghneu.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.enums.LessonType;

@Component
public class StringToTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if(LessonType.LECTURE.getName().equals(text))
			this.setValue(LessonType.LECTURE);
		else if(LessonType.PRACTICE.getName().equals(text))
			this.setValue(LessonType.PRACTICE);
	}

}
