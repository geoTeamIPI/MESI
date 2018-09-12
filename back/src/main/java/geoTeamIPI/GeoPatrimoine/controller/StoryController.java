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

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.service.StoryService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@RestController
@RequestMapping("/stories")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class StoryController {

	@Autowired
	private StoryService storyService;

	@Autowired
	private UserService userService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// ------------------------------------ COUNT METHODS ------------------------

	// COUNT ALL STORIES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return storyService.countAllStories();
	}

	// COUNT ALL STORIES OF A USER - ADMIN AND USER MODES
	@GetMapping("/count/user")
	public int countAllOfUser(@RequestHeader(value = "idUser") Long idUser) {
		return storyService.countAllStories(idUser);
	}

	// COUNT ALL STORIES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/count/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByScreen(
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return storyService.countAllStories(longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// COUNT ALL STORIES BY SCREEN OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/count/user/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByScreenOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return storyService.countAllStories(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// COUNT ALL STORIES BY DIAMETER - ADMIN AND USER MODES
	@RequestMapping(value = "/count/diameter", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByDiameter(
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE,
			@RequestParam("longitudeUser") String longitudeUser,
			@RequestParam("latitudeUser") String latitudeUser,
			@RequestParam("diameter") int diameter) {
		return storyService.countAllStories(longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser,
				latitudeUser, diameter);
	}

	// COUNT ALL STORIES BY DIAMETER OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/count/user/diameter", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public int countAllByDiameterOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE,
			@RequestParam("longitudeUser") String longitudeUser,
			@RequestParam("latitudeUser") String latitudeUser,
			@RequestParam("diameter") int diameter) {
		return storyService.countAllStories(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser,
				latitudeUser, diameter);
	}

	// ------------------------------------ LIST METHODS ------------------------

	// LIST ALL STORIES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAll() {
		return storyService.findAllStories();
	}

	// LIST ALL STORIES OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfUser(
			@RequestHeader(value = "idUser") Long idUser) {
		return storyService.findAllStories(idUser);
	}

	// LIST ALL STORIES BY SCREEN - ADMIN AND USER MODES
	@RequestMapping(value = "/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllByScreen(
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return storyService.findAllStories(longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// LIST ALL STORIES BY SCREEN OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user/screen", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllByScreenOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE) {
		return storyService.findAllStories(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE);
	}

	// LIST ALL STORIES BY DIAMETER - ADMIN AND USER MODES
	@RequestMapping(value = "/diameter", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllByDiameter(
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE,
			@RequestParam("longitudeUser") String longitudeUser,
			@RequestParam("latitudeUser") String latitudeUser,
			@RequestParam("diameter") int diameter) {
		return storyService.findAllStoriesByDiameter(longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser, latitudeUser, diameter);
	}

	// LIST ALL STORIES BY DIAMETER OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user/diameter", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllByDiameterOfUser(
			@RequestHeader(value = "idUser") Long idUser,
			@RequestParam("longitudeSW") String longitudeSW,
			@RequestParam("latitudeSW") String latitudeSW,
			@RequestParam("longitudeNE") String longitudeNE,
			@RequestParam("latitudeNE") String latitudeNE,
			@RequestParam("longitudeUser") String longitudeUser,
			@RequestParam("latitudeUser") String latitudeUser,
			@RequestParam("diameter") int diameter) {
		return storyService.findAllStoriesByDiameter(idUser, longitudeSW, latitudeSW, longitudeNE, latitudeNE, longitudeUser, latitudeUser,
				diameter);
	}

	// LIST ALL STORIES OF A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/place", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfPlace(
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude) {
		return storyService.findAllStoriesByPlace(longitude, latitude);
	}

	// LIST ALL STORIES OF A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/placeId", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfPlaceById(
			@RequestParam("idPlace") Long idPlace) {
		return storyService.findAllStoriesByPlace(idPlace);
	}

	// LIST ALL STORIES OF A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/timelapseId", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfTimelapseById(
			@RequestParam("idTimelapse") Long idTimelapse) {
		return storyService.findAllStoriesByTimelapse(idTimelapse);
	}

	// LIST ALL STORIES OF A TYPE - ADMIN AND USER MODES
	@RequestMapping(value = "/typeId", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfTypeById(
			@RequestParam("idType") Long idType) {
		return storyService.findAllStoriesByType(idType);
	}

	// LIST ALL STORIES OF A CREATOR - ADMIN AND USER MODES
	@RequestMapping(value = "/creatorId", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfCreatorById(
			@RequestParam("idCreator") Long idCreator) {
		return storyService.findAllStoriesByType(idCreator);
	}
	// ------------------------------------ CRUD METHODS ------------------------

	// CREATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Story createOfMyself(
			@RequestBody Story story, BindingResult result,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		return this.storyService.createStory(story, user);
	}

	// DISPLAY A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Story display(
			@PathVariable(value = "id") Long id) {
		Story result = storyService.findById(id);
		return result;
	}

	// DELETE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteOfMyself(
			@PathVariable("id") Long id,
			@RequestHeader(value = "idUser") Long idUser) {
		Story result = storyService.findById(id);
		User user = userService.findById(idUser);
		this.storyService.deleteStory(result, user);
	}

	// UPDATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateOfMyself(
			@PathVariable("id") Long id,
			@RequestBody Story story,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		this.storyService.updateStory(id, story, user);
	}

}
