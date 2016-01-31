package com.rozdolskyi.traininghneu.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.facade.SubjectFacade;

@Component
public class StringToSubjectEditor extends PropertyEditorSupport {
	
	@Autowired
	private SubjectFacade subjectFacade;

	@Override
	public void setAsText(String text) {
		SubjectData subjectData = subjectFacade.getSubject(text);
		this.setValue(subjectData);
	}

}
