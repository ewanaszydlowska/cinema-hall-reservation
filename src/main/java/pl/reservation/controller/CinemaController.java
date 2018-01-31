package pl.reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.reservation.entity.Cinema;
import pl.reservation.repository.CinemaRepository;

@Controller
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	private CinemaRepository cinemaRepo;
	
	@GetMapping("/add")
	public String addCinema(Model m) {
		m.addAttribute("cinema", new Cinema());
		return "cinema/add";
		
	}
	
	@PostMapping("/add")
	public String addCinemaPost(Model m, @Valid @ModelAttribute Cinema cinema, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/cinema/add";
		}
		this.cinemaRepo.save(cinema);
		m.addAttribute("message", "Dodano kino do bazdy danych.");
		return "redirect:/";
		
	}

}
