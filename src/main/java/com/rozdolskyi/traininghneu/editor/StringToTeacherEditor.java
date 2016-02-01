package com.rozdolskyi.traininghneu.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.facade.TeacherFacade;

@Component
public class StringToTeacherEditor extends PropertyEditorSupport {
	
	@Autowired
	private TeacherFacade teacherFacade;

	@Override
	public void setAsText(String text) {
		TeacherData teacherData = teacherFacade.getTeacher(text);
		this.setValue(teacherData);
	}

}
