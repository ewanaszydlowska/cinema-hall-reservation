package pl.reservation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pl.reservation.bean.SessionManager;
import pl.reservation.entity.Movie;
import pl.reservation.entity.User;
import pl.reservation.repository.MovieRepository;

@Controller
@RequestMapping("/movie")
public class MovieController {

	
	@Autowired
	MovieRepository movieRepo;
	
	@GetMapping("/add")
	public String addMovie(Model m) {
		m.addAttribute("movie", new Movie());
		return "movie/addmovie";
	}
	
	@PostMapping("/add")
	public String addMovieForm(@Valid @ModelAttribute Movie movie, BindingResult bindingResult,
		@RequestParam("photo") MultipartFile file, RedirectAttributes ra, Model m) {
		if (bindingResult.hasErrors()) {
			// return "redirect:/flat/addoffer";
			return "movie/addmovie";
		}


		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");

		movie.setPosterUrl(null);
		String fileName = null;
		movie.setExpired(0);
		this.movieRepo.save(movie);
		Long imgId = movie.getId();
		if (!file.isEmpty()) {
			try {

				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {

					fileName = "movie_" + imgId + "." + extension;
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
							// TODO :: absolute - path & check after deployment without eclipse
							// "./../../../../webapp/WEB-INF/resources/picture/" + fileName)));

							"/home/szymon/workspace/CinemaReservation/cinema-hall-reservation/src/main/webapp/WEB-INF/resources/picture/" + fileName)));

					buffStream.write(bytes);
					buffStream.close();
					// seter dla url
					movie.setPosterUrl(fileName);
					// zapis db
					this.movieRepo.save(movie);
					m.addAttribute("message", "Dodano produkt do bazy.");
					return "redirect:/";

				} else {
					m.addAttribute("eMessage", "Niepoprawny format pliku graficznego.");
					return "redirect:/addmovie";
				}

			} catch (Exception e) {
				return "home";
			}
		}

		m.addAttribute("eMessage", "Brak zdjęcia.");
		return "movie/addmovie";

	}
		
	
	@GetMapping("/{id}")
	public String singleMovie(Model m, @PathVariable Long id) {
		Movie movie = movieRepo.findOne(id);
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		m.addAttribute("user", u);
		m.addAttribute("movie", movie);
		return "movie/single_movie";
	}
	
	
	@ModelAttribute("type")
	public List<String> getType() {
		String type[] = new String[] {"Akcja", "Animacja", "Dokumentalny", "Dramat", "Familijny",
				"Fantasy", "Horror", "Komedia", "Kryminal", "Melodramat", "Niemy", "Przygodowy",
				"Romans", "Thriller"};
		Arrays.sort(type);
		return Arrays.asList(type);
	}

	@ModelAttribute("ageLimit")
	public List<String> getageLimit() {
		String ageLimit[] = new String[] {"Brak ograniczen", "12", "16", "18"};
		Arrays.sort(ageLimit);
		return Arrays.asList(ageLimit);
	}
}
