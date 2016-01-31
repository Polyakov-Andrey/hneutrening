package com.rozdolskyi.traininghneu.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;

@Component
public class StringToSubjectEditor extends PropertyEditorSupport {
	
	@Autowired
	private ManagementFacade managementFacade;

	@Override
	public void setAsText(String text) {
		SubjectData subjectData = managementFacade.getSubject(text);
		this.setValue(subjectData);
	}

}
