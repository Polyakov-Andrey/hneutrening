package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.model.SubjectModel;

@Component
public class SubjectDataToModelConverter implements Converter<SubjectData, SubjectModel> {

	public SubjectModel convert(SubjectData subjectData) {
		SubjectModel subjectModel = new SubjectModel();
		subjectModel.setId(subjectData.getId());
		subjectModel.setName(subjectData.getName());
		subjectModel.setPrice(subjectData.getPrice());
		return subjectModel;
	}

}
