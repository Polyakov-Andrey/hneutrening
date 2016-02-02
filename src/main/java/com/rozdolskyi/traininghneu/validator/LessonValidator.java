package com.rozdolskyi.traininghneu.validator;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rozdolskyi.traininghneu.data.LessonData;
import com.rozdolskyi.traininghneu.data.SubjectData;

@Component
public class LessonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LessonData.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LessonData lessonData = (LessonData) object;
		SubjectData selectedSubject = lessonData.getSubject();
		List<SubjectData> teacherSubjects = lessonData.getTeacher().getSubjects();
		if(teacherSubjects == null || !teacherSubjects.contains(selectedSubject)) {
			errors.rejectValue("teacher", "error.teacher.invalid.for.subject");
		}
	}

}
