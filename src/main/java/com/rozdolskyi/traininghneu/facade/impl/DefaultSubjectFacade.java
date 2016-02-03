package com.rozdolskyi.traininghneu.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.facade.SubjectFacade;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.service.SubjectService;

@Component
public class DefaultSubjectFacade implements SubjectFacade {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private Converter<SubjectData, SubjectModel> subjectDataToModelConverter;
	@Autowired
	private Converter<SubjectModel, SubjectData> subjectModelToDataConverter;

	@Override
	public void addSubject(SubjectData subjectData) {
		SubjectModel subjectModel = subjectDataToModelConverter.convert(subjectData);
		subjectService.addSubject(subjectModel);
	}

	@Override
	public List<SubjectData> getSubjects() {
		List<SubjectData> subjectData = subjectService.getSubjects().stream()
				.map(subjectModelToDataConverter::convert).collect(Collectors.toList());
		return subjectData;
	}

	@Override
	public void removeSubject(String id) {
		subjectService.removeSubject(id);
	}

	@Override
	public SubjectData getSubject(String id) {
		return subjectModelToDataConverter.convert(subjectService.getSubject(id));
	}

	@Override
	public void saveSubject(SubjectData subjectData) {
		SubjectModel subjectModel = subjectDataToModelConverter.convert(subjectData);
		subjectService.saveSubject(subjectModel);
	}

}
