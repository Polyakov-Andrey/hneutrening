package com.rozdolskyi.traininghneu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.TeacherDao;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.service.SubjectService;

@Service
public class DefaultSubjectService implements SubjectService {
	
	@Autowired
	private TeacherDao managementDao;

	@Override
	public void addSubject(SubjectModel subjectModel) {
		managementDao.addSubject(subjectModel);
	}

	@Override
	public List<SubjectModel> getSubjects() {
		return managementDao.getSubjects();
	}

	@Override
	public void removeSubject(String id) {
		managementDao.removeSubject(id);
	}

	@Override
	public SubjectModel getSubject(String id) {
		return managementDao.getSubject(id);
	}

}
