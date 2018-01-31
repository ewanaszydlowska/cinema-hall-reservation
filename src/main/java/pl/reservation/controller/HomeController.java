package pl.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(value = {"", "/home"})
	public String home(Model m, @RequestParam(required = false) String message) {
		m.addAttribute("message", message);
		return "home";
	}
	
	
}
