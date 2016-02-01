package com.rozdolskyi.traininghneu.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.facade.GroupFacade;

@Component
public class StringToGroupEditor extends PropertyEditorSupport {
	
	@Autowired
	private GroupFacade groupFacade;

	@Override
	public void setAsText(String text) {
		GroupData groupData = groupFacade.getGroup(text);
		this.setValue(groupData);
	}

}
