package com.rozdolskyi.traininghneu.facade;

import java.util.List;

import com.rozdolskyi.traininghneu.data.SubjectData;

public interface SubjectFacade {

	void addSubject(SubjectData subject);

	List<SubjectData> getSubjects();

	void removeSubject(String id);

	SubjectData getSubject(String id);

}
