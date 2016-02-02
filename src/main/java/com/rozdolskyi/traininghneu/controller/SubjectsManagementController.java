package com.rozdolskyi.traininghneu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rozdolskyi.traininghneu.data.SubjectData;
import com.rozdolskyi.traininghneu.facade.SubjectFacade;

@Controller
@RequestMapping(value = "management/subjects")
public class SubjectsManagementController {

	@Autowired
	private SubjectFacade subjectFacade;

	@RequestMapping
	public String getAllSubjects(ModelMap model) {
		List<SubjectData> subjects = subjectFacade.getSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addSubject() {
		return new ModelAndView("addNewSubject", "subject", new SubjectData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") @Valid SubjectData subject, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addNewSubject";
		subjectFacade.addSubject(subject);
		return "redirect:/management/subjects";
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		subjectFacade.removeSubject(id);
		return "redirect:/management/subjects";
	}

}
