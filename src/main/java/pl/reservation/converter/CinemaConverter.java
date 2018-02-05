package pl.reservation.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.reservation.entity.Cinema;
import pl.reservation.repository.CinemaRepository;


public class CinemaConverter implements Converter<String, Cinema> {

	@Autowired
	private CinemaRepository cinemaRepo;
	
	@Override
	public Cinema convert(String source) {
		Cinema cinema = this.cinemaRepo.findOne(Long.parseLong(source));
		return cinema;
	}

}