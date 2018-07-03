package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	// COUNT ALL STORIES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return storyService.countAllStories();
	}

	// COUNT ALL STORIES OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/count/user/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public int countAllOfUser(@PathVariable(value = "id") Long id) {
		User user = userService.findById(id);
		return storyService.findAllStoriesOfUser(user).size();
	}

	// COUNT ALL MY STORIES - ADMIN AND USER MODES
	@GetMapping("/count/myself")
	public int countAllOfMyself(@RequestHeader(value = "idConnectedUser") Long idConnectedUser) {
		return storyService.countAllStoriesOfMyself(idConnectedUser);
	}

	// LIST ALL STORIES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAll() {
		return storyService.findAllStories();
	}

	// LIST ALL STORIES WITH PAGINATION - ADMIN AND USER MODES
	@RequestMapping(value = "/pagin", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Page<Story> listAllPagination(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("sortProperty") String sortProperty, @RequestParam("sortDirection") String sortDirection) {
		Page<Story> pagin = storyService.findAllStories(page, size, sortProperty, sortDirection);
		return pagin;
	}

	// LIST ALL STORIES OF A USER - ADMIN AND USER MODES
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfUser(@PathVariable(value = "id") Long id) {
		User user = userService.findById(id);
		return storyService.findAllStoriesOfUser(user);
	}

	// LIST ALL STORIES OF A USER WITH PAGINATION - ADMIN AND USER MODES
	@RequestMapping(value = "/user/{id}/pagin", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Page<Story> listAllOfUserPagination(@PathVariable(value = "id") Long id, @RequestParam("page") Integer page,
			@RequestParam("size") Integer size, @RequestParam("sortProperty") String sortProperty,
			@RequestParam("sortDirection") String sortDirection) {
		User result = userService.findById(id);
		Page<Story> pagin = storyService.findAllStoriesOfUser(result, page, size, sortProperty, sortDirection);
		return pagin;
	}

	// LIST ALL MY STORIES - ADMIN AND USER MODES
	@RequestMapping(value = "/user/myself", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Story> listAllOfMyself(@RequestHeader(value = "idConnectedUser") Long idConnectedUser) {
		return storyService.findAllStoriesOfMyself(idConnectedUser);
	}

	// LIST ALL MY STORIES WITH PAGINATION - ADMIN AND USER MODES
	@RequestMapping(value = "/user/myself/pagin", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Page<Story> listAllOfMyselfPagination(@RequestHeader(value = "idConnectedUser") Long idConnectedUser,
			@RequestParam("page") Integer page,
			@RequestParam("size") Integer size, @RequestParam("sortProperty") String sortProperty,
			@RequestParam("sortDirection") String sortDirection) {
		Page<Story> pagin = storyService.findAllStoriesOfMyself(idConnectedUser, page, size, sortProperty, sortDirection);
		return pagin;
	}

	// CREATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	// public Story create(@RequestBody Story story, BindingResult result, @RequestHeader(value = "id") Long id) {
	public Story create(@RequestBody Story story, BindingResult result) {
		// return this.storyService.createStory(story, id);
		return this.storyService.createStory(story);
	}

	// DISPLAY A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Story display(@PathVariable(value = "id") Long id) {
		Story result = storyService.findById(id);
		return result;
	}

	// DELETE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		Story result = storyService.findById(id);
		this.storyService.deleteStory(result);
	}

	// UPDATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Story update(@PathVariable("id") Long id, @RequestBody Story story) {
		return this.storyService.updateStory(id, story);
	}

}
