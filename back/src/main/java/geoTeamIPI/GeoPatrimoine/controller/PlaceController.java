package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.service.PlaceService;

@RestController
@RequestMapping("/places")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// COUNT ALL PLACES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return placeService.countAllPlaces();
	}

	// COUNT ALL PLACES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/count/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByScreen(@RequestParam("longitudeSW") String longitudeSW, @RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE, @RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(longitudeSW, latitudeSW, longitudeNE, latitudeNE).size();
	}

	// LIST ALL PLACES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAll() {
		return placeService.findAllPlaces();
	}

	// LIST ALL PLACES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAllByScreen(@RequestParam("longitudeSW") String longitudeSW, @RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE, @RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// CREATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Place create(@RequestBody Place place, BindingResult result) {
		return this.placeService.createPlace(place);
	}

	// DISPLAY A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Place display(@PathVariable(value = "id") Long id) {
		Place result = placeService.findById(id);
		return result;
	}

	// DELETE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		Place result = placeService.findById(id);
		this.placeService.deletePlace(result);
	}

	// UPDATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Place update(@PathVariable("id") Long id, @RequestBody Place place) {
		return this.placeService.updatePlace(id, place);
	}

}
