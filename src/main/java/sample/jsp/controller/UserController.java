package sample.jsp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.model.User;
import sample.jsp.service.UserService;

@Controller

public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users")
	public String userList(Map<String, Object> model) {
		model.put("users", userService.getUsers());

		return "/users/index";
	}

	@RequestMapping(value = "/users/create", method = RequestMethod.GET)
	public String createRequest() {
		return "/users/create";
	}

	@RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
	public ModelAndView showEditedUser(@PathVariable long id) {
		// @PathVariable long id
		return new ModelAndView("/users/edit", "user", userService.getUser(id));

	}
	@RequestMapping(value = "/users/updated",  method = RequestMethod.POST)
	public String updateUser(
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "address", required = true) String address) {
			
		userService.updateUser(id, firstname, lastname, address);
		
		return "redirect:/users";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveUser(
			/*
			 * @RequestParam("firstname") String firstname,
			 * 
			 * @RequestParam("lastname") String lastname,
			 * 
			 * @RequestParam("address") String address
			 */
			// it works with both syntax.
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "address", required = true) String address) {
		userService.saveUser(id,firstname,lastname,address);
		return "redirect:/users";
	}

}

