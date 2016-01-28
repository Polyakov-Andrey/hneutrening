package com.rozdolskyi.traininghneu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
public class InfoController {

	@RequestMapping
	public ModelAndView infoPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("info");
		return model;
	}
	
}