package com.rozdolskyi.traininghneu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.ManagementDao;
import com.rozdolskyi.traininghneu.model.SubjectModel;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.ManagementService;

@Service
public class DefaultManagementService implements ManagementService {
	
	@Autowired
	private ManagementDao managementDao;

	@Override
	public void addTeaher(TeacherModel teacherModel) {
		managementDao.addTeacher(teacherModel);
	}

	@Override
	public void addSubject(SubjectModel subjectModel) {
		managementDao.addSubject(subjectModel);
	}

	@Override
	public List<TeacherModel> getTeachers() {
		return managementDao.getTeachers();
	}

	@Override
	public List<SubjectModel> getSubjects() {
		return managementDao.getSubjects();
	}

	@Override
	public void removeTeacher(String id) {
		managementDao.removeTeacher(id);
	}

	@Override
	public void removeSubject(String id) {
		managementDao.removeSubject(id);
	}

	@Override
	public TeacherModel getTeacher(String id) {
		return managementDao.getTeacher(id);
	}

	@Override
	public SubjectModel getSubject(String id) {
		return managementDao.getSubject(id);
	}

}
