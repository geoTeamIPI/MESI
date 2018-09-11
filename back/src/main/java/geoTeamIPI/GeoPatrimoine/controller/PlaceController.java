package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.entity.Place;
import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.exception.PlaceExceptionHandler;
import geoTeamIPI.GeoPatrimoine.service.PlaceService;
import geoTeamIPI.GeoPatrimoine.service.StoryService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@RestController
@RequestMapping("/places")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@Autowired
	private UserService userService;

	@Autowired
	private StoryService storyService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// ------------------------------------ COUNT METHODS ------------------------

	// COUNT ALL PLACES - ADMIN AND USER MODES
	@GetMapping("/count")
	public int countAll() {
		return placeService.countAllPlaces();
	}

	// COUNT ALL PLACES OF A USER - ADMIN AND USER MODES
	@GetMapping("/count/user")
	public int countAllOfUser(@RequestHeader(value = "idUser") Long idUser) {
		return placeService.countAllPlaces(idUser);
	}

	// COUNT ALL PLACES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/count/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByScreen(@RequestParam("longitudeSW") String longitudeSW, @RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE, @RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(longitudeSW, latitudeSW, longitudeNE, latitudeNE).size();
	}

	// COUNT ALL PLACES BY SCREEN OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/count/user/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByScreenOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE).size();
	}

	// ------------------------------------ LIST METHODS ------------------------

	// LIST ALL PLACES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAll() {
		return placeService.findAllPlaces();
	}

	// LIST ALL PLACES OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAllOfUser(
			@RequestHeader(value = "idUser") Long idUser) {
		return placeService.findAllPlaces(idUser);
	}

	// LIST ALL PLACES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAllByScreen(@RequestParam("longitudeSW") String longitudeSW, @RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE, @RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// LIST ALL PLACES BY SCREEN OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAllByScreenOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return placeService.findAllPlaces(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// LIST ALL PLACES - ADMIN AND USER MODES
	@RequestMapping(value = "/compare", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Place> listAllEmptyPlaces() {
		return placeService.findAllEmptyPlaces();
	}

	// ------------------------------------ CRUD METHODS ------------------------

	// CREATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Place create(@RequestBody Place place, @RequestHeader(value = "idUser") Long idUser, BindingResult result) {
		return this.placeService.createPlace(place, idUser);
	}

	// DISPLAY A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Place display(@PathVariable(value = "id") Long id) {
		Place result = placeService.findById(id);
		return result;
	}

	// DELETE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id, @RequestHeader(value = "idUser") Long idUser) {
		Place result = placeService.findById(id);
		Boolean isAdmin = isAdmin(idUser);
		if (!placeService.findById(id).getCreator().equals(idUser) && isAdmin.equals(false)) {
			PlaceExceptionHandler.notTheCreator();
		}
		List<Story> storiesLinked = storyService.findAllStoriesByPlace(result.getLongitude(), result.getLatitude());
		if (storiesLinked.size() >= 1) {
			PlaceExceptionHandler.tooManyStoriesLinked();
		}
		this.placeService.deletePlace(result);
	}

	// UPDATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Place update(@PathVariable("id") Long id, @RequestBody Place place, @RequestHeader(value = "idUser") Long idUser) {
		Boolean isAdmin = isAdmin(idUser);
		if (!placeService.findById(id).getCreator().equals(idUser) && isAdmin.equals(false)) {
			PlaceExceptionHandler.notTheCreator();
		}
		List<Story> storiesLinked = storyService.findAllStoriesByPlace(place.getLongitude(), place.getLatitude());
		if (storiesLinked.size() >= 5) {
			PlaceExceptionHandler.tooManyStoriesLinked();
		} else if (storiesLinked.size() == 1) {
			for (Story story : storiesLinked) {
				if (!story.getCreator().getId().equals(idUser) && isAdmin.equals(false)) {
					PlaceExceptionHandler.notTheCreator();
				}
			}
		}
		return this.placeService.updatePlace(id, place);
	}

	// ------------------------------------ SUB METHODS ------------------------^^

	private boolean isAdmin(Long idUser) {
		if (userService.findById(idUser).getProfile().equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

}
