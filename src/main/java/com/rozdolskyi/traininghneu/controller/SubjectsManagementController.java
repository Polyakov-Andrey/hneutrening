package com.rozdolskyi.traininghneu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;

@Controller
@RequestMapping(value = "management/subjects")
public class SubjectsManagementController {

	@Autowired
	private ManagementFacade managementFacade;
	
	@RequestMapping
	public String getAllSubjects(ModelMap model) {
		List<SubjectData> subjects = managementFacade.getSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addSubject() {
		return new ModelAndView("addNewSubject", "command", new SubjectData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") SubjectData subject) {
		managementFacade.addSubject(subject);
		return "redirect:/management";
	}
	
}
