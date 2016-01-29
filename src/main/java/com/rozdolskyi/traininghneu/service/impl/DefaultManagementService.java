package com.rozdolskyi.traininghneu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.ManagementDao;
import com.rozdolskyi.traininghneu.model.TeacherModel;
import com.rozdolskyi.traininghneu.service.ManagementService;

@Service
public class DefaultManagementService implements ManagementService {
	
	@Autowired
	private ManagementDao managementDao;

	public void addTeaher(TeacherModel teacherModel) {
		managementDao.addTeacher(teacherModel);
	}

}
