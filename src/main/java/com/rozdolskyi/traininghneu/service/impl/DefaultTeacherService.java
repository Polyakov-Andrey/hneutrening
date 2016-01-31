package com.rozdolskyi.traininghneu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.TeacherDao;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.TeacherService;

@Service
public class DefaultTeacherService implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void addTeaher(TeacherModel teacherModel) {
		teacherDao.addTeacher(teacherModel);
	}

	@Override
	public List<TeacherModel> getTeachers() {
		return teacherDao.getTeachers();
	}

	@Override
	public void removeTeacher(String id) {
		teacherDao.removeTeacher(id);
	}

	@Override
	public TeacherModel getTeacher(String id) {
		return teacherDao.getTeacher(id);
	}

}
