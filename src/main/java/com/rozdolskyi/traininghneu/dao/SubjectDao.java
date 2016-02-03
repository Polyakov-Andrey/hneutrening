package com.rozdolskyi.traininghneu.dao;

import java.util.List;

import com.rozdolskyi.traininghneu.model.SubjectModel;

public interface SubjectDao {

	void addSubject(SubjectModel subjectModel);

	List<SubjectModel> getSubjects();

	void removeSubject(String id);

	SubjectModel getSubject(String id);

	void saveSubject(SubjectModel subjectModel);

}
