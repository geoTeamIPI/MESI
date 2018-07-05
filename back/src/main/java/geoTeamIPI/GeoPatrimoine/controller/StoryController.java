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

	// LIST ALL STORIES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAll() {
		return storyService.findAllStories();
	}

	// LIST ALL STORIES OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfUser(@RequestHeader(value = "idUser") Long idUser) {
		return storyService.findAllStories(idUser);
	}

	// CREATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Story createOfMyself(@RequestBody Story story, BindingResult result, @RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		return this.storyService.createStory(story, user);
	}

	// DISPLAY A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Story display(@PathVariable(value = "id") Long id) {
		Story result = storyService.findById(id);
		return result;
	}

	// DELETE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteOfMyself(@PathVariable("id") Long id, @RequestHeader(value = "idUser") Long idUser) {
		Story result = storyService.findById(id);
		User user = userService.findById(idUser);
		this.storyService.deleteStory(result, user);
	}

	// UPDATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateOfMyself(@PathVariable("id") Long id, @RequestBody Story story, @RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		this.storyService.updateStory(id, story, user);
	}

}
