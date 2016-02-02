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

import com.rozdolskyi.traininghneu.data.GroupData;
import com.rozdolskyi.traininghneu.facade.GroupFacade;

@Controller
@RequestMapping(value = "management/groups")
public class GroupsManagementController {

	@Autowired
	private GroupFacade groupFacade;

	@RequestMapping
	public String getAllGroups(ModelMap model) {
		List<GroupData> groups = groupFacade.getGroups();
		model.addAttribute("groups", groups);
		return "groups";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addGroup() {
		return new ModelAndView("addNewGroup", "group", new GroupData());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGroup(@ModelAttribute("group") @Valid GroupData group, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addNewGroup";
		groupFacade.addGroup(group);
		return "redirect:/management/groups";
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable String id) {
		groupFacade.removeGroup(id);
		return "redirect:/management/groups";
	}

}
