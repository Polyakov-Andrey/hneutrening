package com.rozdolskyi.traininghneu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.data.LessonData;
import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.editor.StringToGroupEditor;
import com.rozdolskyi.traininghneu.editor.StringToSubjectEditor;
import com.rozdolskyi.traininghneu.editor.StringToTeacherEditor;
import com.rozdolskyi.traininghneu.editor.StringToTypeEditor;
import com.rozdolskyi.traininghneu.enums.LessonType;
import com.rozdolskyi.traininghneu.facade.GroupFacade;
import com.rozdolskyi.traininghneu.facade.LessonFacade;
import com.rozdolskyi.traininghneu.facade.SubjectFacade;
import com.rozdolskyi.traininghneu.facade.TeacherFacade;

@Controller
@RequestMapping(value = "management/lessons")
public class LessonsManagementController {

	@Autowired
	private LessonFacade lessonFacade;
	@Autowired
	private SubjectFacade subjectFacade;
	@Autowired
	private TeacherFacade teacherFacade;
	@Autowired
	private GroupFacade groupFacade;
	@Autowired
	private StringToSubjectEditor subjectEditor;
	@Autowired
	private StringToTeacherEditor teacherEditor;
	@Autowired
	private StringToGroupEditor groupEditor;
	@Autowired
	private StringToTypeEditor typeEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(SubjectData.class, subjectEditor);
		binder.registerCustomEditor(TeacherData.class, teacherEditor);
		binder.registerCustomEditor(GroupData.class, groupEditor);
		binder.registerCustomEditor(LessonType.class, typeEditor);
	}

	
	@RequestMapping
	public String getAllLessons(ModelMap model) {
		List<LessonData> lessons = lessonFacade.getLessons();
		model.addAttribute("lessons", lessons);
		return "lessons";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addLesson(ModelMap model) {
		model.addAttribute("subjects", subjectFacade.getSubjects());
		model.addAttribute("teachers", teacherFacade.getTeachers());
		model.addAttribute("groups", groupFacade.getGroups());
		model.addAttribute("types", LessonType.values());
		return new ModelAndView("addNewLesson", "command", new LessonData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addLesson(@ModelAttribute("lesson") LessonData lesson) {
		lessonFacade.addLesson(lesson);
		return "redirect:/management/lessons";
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		lessonFacade.removeLesson(id);
		return "redirect:/management/lessons";
	}

}
