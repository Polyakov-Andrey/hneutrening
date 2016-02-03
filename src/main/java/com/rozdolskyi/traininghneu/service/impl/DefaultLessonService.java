package com.rozdolskyi.traininghneu.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rozdolskyi.traininghneu.dao.LessonDao;
import com.rozdolskyi.traininghneu.enums.LessonType;
import com.rozdolskyi.traininghneu.model.LessonModel;
import com.rozdolskyi.traininghneu.service.LessonService;

@Service
public class DefaultLessonService implements LessonService{

	private static final double EXPERIENCE_COEFFICIENT = 0.05D;
	private static final double PRACTICE_COEEFICIENT = 1D;
	private static final double LECTURE_COEFICIENT = 1.2D;
	
	@Autowired
	private LessonDao lessonDao;
	
	@Override
	public void addLesson(LessonModel lessonModel) {
		lessonModel.setPrice(calculatePrice(lessonModel).setScale(2));
		lessonDao.addLesson(lessonModel);
	}

	private BigDecimal calculatePrice(LessonModel lessonModel) {
		double premiumCoefficient = lessonModel.getTeacher().getExperience() * EXPERIENCE_COEFFICIENT;
		double lessonTypeCoefficient = getLessonTypeCoeffiect(lessonModel.getType());
		BigDecimal subjectDefaultPrice = lessonModel.getSubject().getPrice();
		BigDecimal premium = subjectDefaultPrice.multiply(BigDecimal.valueOf(premiumCoefficient));
		BigDecimal totalLessonPrice = subjectDefaultPrice.add(premium).multiply(BigDecimal.valueOf(lessonTypeCoefficient));
		return totalLessonPrice;
	}

	private double getLessonTypeCoeffiect(LessonType type) {
		if(LessonType.LECTURE.equals(type)) 
			return LECTURE_COEFICIENT;
		return PRACTICE_COEEFICIENT;
	}

	@Override
	public List<LessonModel> getLessons() {
		return lessonDao.getLessons();
	}

	@Override
	public void removeLesson(String id) {
		lessonDao.removeLesson(id);	
	}

	@Override
	public LessonModel getLesson(String id) {
		return lessonDao.getLesson(id);
	}

	@Override
	public void saveLesson(LessonModel lessonModel) {
		lessonModel.setPrice(calculatePrice(lessonModel).setScale(2));
		lessonDao.saveLesson(lessonModel);
	}

}
