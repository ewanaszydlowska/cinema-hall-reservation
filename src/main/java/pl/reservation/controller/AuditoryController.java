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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.reservation.entity.Auditory;
import pl.reservation.entity.Cinema;
import pl.reservation.repository.AuditoryRepository;
import pl.reservation.repository.CinemaRepository;

@Controller
@RequestMapping("/auditory")
public class AuditoryController {

	@Autowired
	private AuditoryRepository auditoryRepo;
	
	@Autowired
	private CinemaRepository cinemaRepo;

	@GetMapping("/add")
	public String addAuditory(Model m) {
		m.addAttribute("auditory", new Auditory());
		return "auditory/add";
	}

	@PostMapping("/add")
	public String addAuditoryForm(@Valid @ModelAttribute Auditory auditory, BindingResult bindingResult,
			RedirectAttributes ra, Model m) {
		if (bindingResult.hasErrors()) {
			// return "redirect:/flat/addoffer";
			return "auditory/add";
		}

		this.auditoryRepo.save(auditory);
		m.addAttribute("message", "Auditory added.");
		return "redirect:/";
	}

	@ModelAttribute("availableCinemas")
	public List<Cinema> getAllCinemas() {
		return this.cinemaRepo.findAll();
	}
}
