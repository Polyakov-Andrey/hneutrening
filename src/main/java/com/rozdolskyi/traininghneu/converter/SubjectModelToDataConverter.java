package com.rozdolskyi.traininghneu.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.model.SubjectModel;

@Component
public class SubjectModelToDataConverter implements Converter<SubjectModel, SubjectData> {

	public SubjectData convert(SubjectModel subjectModel) {
		SubjectData subjectData = new SubjectData();
		subjectData.setId(subjectModel.getId());
		subjectData.setName(subjectModel.getName());
		subjectData.setPrice(subjectModel.getPrice());
		return subjectData;
	}

}
