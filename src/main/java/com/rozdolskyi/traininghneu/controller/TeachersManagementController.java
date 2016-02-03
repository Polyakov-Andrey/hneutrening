package com.rozdolskyi.traininghneu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.editor.StringToSubjectEditor;
import com.rozdolskyi.traininghneu.facade.SubjectFacade;
import com.rozdolskyi.traininghneu.facade.TeacherFacade;

@Controller
@RequestMapping(value = "management/teachers")
public class TeachersManagementController {

	@Autowired
	private TeacherFacade teacherFacade;
	@Autowired
	private SubjectFacade subjectFacade;

	@Autowired
	private StringToSubjectEditor subjectEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(SubjectData.class, subjectEditor);
	}

	@RequestMapping
	public String getAllTeachers(ModelMap model) {
		List<TeacherData> teachers = teacherFacade.getTeachers();
		model.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelMap model) {
		prepareModel(model);
		return new ModelAndView("addNewTeacher", "teacher", new TeacherData());
	}

	private void prepareModel(ModelMap model) {
		List<SubjectData> allSubjecs = subjectFacade.getSubjects();
		model.addAttribute("subjectsForChose", allSubjecs);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("teacher") @Valid TeacherData teacher, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			prepareModel(model);
			return "addNewTeacher";
		}
		teacherFacade.addTeacher(teacher);
		return "redirect:/management/teachers";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateTeacher(@PathVariable String id, ModelMap model) {
		TeacherData teacher = teacherFacade.getTeacher(id);
		prepareModel(model);
		return new ModelAndView("updateTeacher", "teacher", teacher);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateTeacher(@ModelAttribute("teacher") @Valid TeacherData teacher, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			prepareModel(model);
			return new ModelAndView("updateTeacher", "teacher", teacher);
		}
		teacherFacade.saveTeacher(teacher);
		return new ModelAndView("redirect:/management/teachers");
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		teacherFacade.removeTeacher(id);
		return "redirect:/management/teachers";
	}
}
