package com.rozdolskyi.traininghneu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rozdolskyi.traininghneu.data.TeacherData;
import com.rozdolskyi.traininghneu.facade.ManagementFacade;

@Controller
@RequestMapping(value = "management/teachers")
public class TeachersManagementController {

	@Autowired
	private ManagementFacade managementFacade;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView managementPage() {
		return new ModelAndView("addNewTeacher", "command", new TeacherData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("teacher") TeacherData teacher) {
		managementFacade.addTeacher(teacher);
		return "redirect:/management";
	}
}
