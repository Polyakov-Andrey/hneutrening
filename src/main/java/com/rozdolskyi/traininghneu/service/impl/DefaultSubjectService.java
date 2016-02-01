package com.rozdolskyi.traininghneu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.SubjectDao;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.service.SubjectService;

@Service
public class DefaultSubjectService implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public void addSubject(SubjectModel subjectModel) {
		subjectDao.addSubject(subjectModel);
	}

	@Override
	public List<SubjectModel> getSubjects() {
		return subjectDao.getSubjects();
	}

	@Override
	public void removeSubject(String id) {
		subjectDao.removeSubject(id);
	}

	@Override
	public SubjectModel getSubject(String id) {
		return subjectDao.getSubject(id);
	}

}
