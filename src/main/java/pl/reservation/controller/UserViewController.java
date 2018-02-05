package pl.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reservation.bean.SessionManager;
import pl.reservation.entity.User;


@Controller
@RequestMapping("/account")
public class UserViewController {

	@GetMapping("")
	public String myaccount(Model m) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		m.addAttribute("user", u);
		return "account/myaccount";
	}
}
