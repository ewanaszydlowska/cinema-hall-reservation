package pl.reservation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.reservation.entity.User;
import pl.reservation.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userrepo;
	

@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "account/register";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "redirect:/register";
		}
		
		List<User> users = this.userrepo.findAll();
		for (User u : users) {
			if (u.getEmail().equals(user.getEmail())) {
				m.addAttribute("msg", "This email address is already used. Try different email.");
				return "account/register";
			}
		}
		this.userrepo.save(user);
		return "redirect:/";
	}
	
	
	
}
