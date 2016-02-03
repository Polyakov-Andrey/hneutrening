package com.rozdolskyi.traininghneu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
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
	@Autowired
	@Qualifier("lessonValidator")
	private Validator validator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(SubjectData.class, subjectEditor);
		binder.registerCustomEditor(TeacherData.class, teacherEditor);
		binder.registerCustomEditor(GroupData.class, groupEditor);
		binder.registerCustomEditor(LessonType.class, typeEditor);
		binder.setValidator(validator);
	}

	@RequestMapping
	public String getAllLessons(ModelMap model) {
		model.addAttribute("lessons", lessonFacade.getLessons());
		return "lessons";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addLesson(ModelMap model) {
		prepareModel(model);
		return new ModelAndView("addNewLesson", "lesson", new LessonData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addLesson(@ModelAttribute("lesson") @Validated LessonData lesson, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			prepareModel(model);
			return new ModelAndView("addNewLesson", "lesson", lesson);
		}
		lessonFacade.addLesson(lesson);
		model.addAttribute("lessons", lessonFacade.getLessons());
		return new ModelAndView("redirect:/management/lessons");
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		lessonFacade.removeLesson(id);
		return "redirect:/management/lessons";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateLesson(@PathVariable String id, ModelMap model) {
		LessonData lesson = lessonFacade.getLesson(id);
		prepareModel(model);
		return new ModelAndView("updateLesson", "lesson", lesson);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateLesson(@ModelAttribute("lesson") @Valid LessonData lesson, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			prepareModel(model);
			return new ModelAndView("updateLesson", "lesson", lesson);
		}
		lessonFacade.saveLesson(lesson);
		return new ModelAndView("redirect:/management/lessons");
	}

	private void prepareModel(ModelMap model) {
		model.addAttribute("subjects", subjectFacade.getSubjects());
		model.addAttribute("teachers", teacherFacade.getTeachers());
		model.addAttribute("groups", groupFacade.getGroups());
		model.addAttribute("types", LessonType.values());
	}
}
