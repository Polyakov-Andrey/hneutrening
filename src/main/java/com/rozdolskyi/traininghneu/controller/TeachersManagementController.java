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

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.editor.StringToSubjectEditor;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;

@Controller
@RequestMapping(value = "management/teachers")
public class TeachersManagementController {

	@Autowired
	private ManagementFacade managementFacade;

	@Autowired
	private StringToSubjectEditor subjectEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(SubjectData.class, subjectEditor);
	}

	@RequestMapping
	public String getAllSubjects(ModelMap model) {
		List<TeacherData> teachers = managementFacade.getTeachers();
		model.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelMap model) {
		List<SubjectData> allSubjecs = managementFacade.getSubjects();
		model.addAttribute("subjectsForChose", allSubjecs);
		return new ModelAndView("addNewTeacher", "command", new TeacherData());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("teacher") TeacherData teacher) {
		managementFacade.addTeacher(teacher);
		return "redirect:/management/teachers";
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		managementFacade.removeTeacher(id);
		return "redirect:/management/teachers";
	}
}
