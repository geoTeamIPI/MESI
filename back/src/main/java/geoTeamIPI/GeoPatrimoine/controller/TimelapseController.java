package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.entity.Timelapse;
import geoTeamIPI.GeoPatrimoine.service.TimelapseService;

@RestController
@RequestMapping("/timelapses")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TimelapseController {

	@Autowired
	private TimelapseService timelapseService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// COUNT ALL PLACES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return timelapseService.countAllTimelapses();
	}

	// LIST ALL PLACES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Timelapse> listAll() {
		return timelapseService.findAllTimelapses();
	}

	// LIST ALL PLACES WITH PAGINATION - ADMIN AND USER MODES
	@RequestMapping(value = "/pagin", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Page<Timelapse> listAllPagination(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("sortProperty") String sortProperty, @RequestParam("sortDirection") String sortDirection) {
		Page<Timelapse> pagin = timelapseService.findAllTimelapses(page, size, sortProperty, sortDirection);
		return pagin;
	}

	// CREATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Timelapse create(@RequestBody Timelapse timelapse, BindingResult result) {
		return this.timelapseService.createTimelapse(timelapse);
	}

	// DISPLAY A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Timelapse display(@PathVariable(value = "id") Long id) {
		Timelapse result = timelapseService.findById(id);
		return result;
	}

	// DELETE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		Timelapse result = timelapseService.findById(id);
		this.timelapseService.deleteTimelapse(result);
	}

	// UPDATE A PLACEs - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Timelapse update(@PathVariable("id") Long id, @RequestBody Timelapse timelapse) {
		return this.timelapseService.updateTimelapse(id, timelapse);
	}

}