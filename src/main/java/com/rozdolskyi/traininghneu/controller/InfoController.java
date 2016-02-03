package com.rozdolskyi.traininghneu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rozdolskyi.traininghneu.facade.TeacherFacade;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private TeacherFacade teacherFacade;
	
	@RequestMapping
	public String infoPage(ModelMap model) {
		model.addAttribute("teachers", teacherFacade.getTeachers());
		return "info";
	}
	
}