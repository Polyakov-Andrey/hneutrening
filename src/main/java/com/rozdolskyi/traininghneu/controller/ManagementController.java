package com.rozdolskyi.traininghneu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {

	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public ModelAndView managementPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("management");
		return model;
	}

}
