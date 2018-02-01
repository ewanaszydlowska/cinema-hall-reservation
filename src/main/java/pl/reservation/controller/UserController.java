package pl.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.reservation.bean.LoginData;
import pl.reservation.bean.SessionManager;
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
			return "account/register";
		}
		
		List<User> users = this.userrepo.findAll();
		for (User u : users) {
			if (u.getEmail().equals(user.getEmail())) {
				m.addAttribute("msg", "This email address is already used. Try different email.");
				return "account/register";
			}
		}
		this.userrepo.save(user);
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "account/login";
	}

	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model m, RedirectAttributes ra) {
		User u = this.userrepo.findOneByemail(loginData.getEmail());
			if (u != null && u.isPasswordCorrect(loginData.getPassword())) {
				HttpSession s = SessionManager.session();
				s.setAttribute("user", u);
				ra.addFlashAttribute("msg", "Logged as" + u.getFirstName()+u.getLastName());
				return "redirect:/home";
		}
		m.addAttribute("msg", "Invalid username or password");
		return "account/login";
	}
	
	@GetMapping("/logout")
	public String logout(Model m) {
		HttpSession s = SessionManager.session();
		s.invalidate();
		return "redirect:/home";
	}
	
	
}
