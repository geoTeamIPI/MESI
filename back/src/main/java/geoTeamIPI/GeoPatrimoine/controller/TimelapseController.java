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

import geoTeamIPI.GeoPatrimoine.entity.Timelapse;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.exception.TimelapseExceptionHandler;
import geoTeamIPI.GeoPatrimoine.service.TimelapseService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@RestController
@RequestMapping("/timelapses")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TimelapseController {

	@Autowired
	private TimelapseService timelapseService;

	@Autowired
	private UserService userService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// COUNT ALL TIMELAPSES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return timelapseService.countAllTimelapses();
	}

	// LIST ALL TIMELAPSES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Timelapse> listAll() {
		return timelapseService.findAllTimelapses();
	}

	// LIST ALL TIMELAPSES TO APPROVE - ADMIN
	@RequestMapping(value = "/approve", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Timelapse> listAllApprove() {
		return timelapseService.findAllTimelapsesApprove();
	}

	// CREATE A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Timelapse create(
			@RequestBody Timelapse timelapse,
			BindingResult result,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		return this.timelapseService.createTimelapse(timelapse, user);
	}

	// DISPLAY A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Timelapse display(@PathVariable(value = "id") Long id) {
		Timelapse result = timelapseService.findById(id);
		return result;
	}

	// DELETE A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("id") Long id,
			@RequestHeader(value = "idUser") Long idUser) {
		Timelapse result = timelapseService.findById(id);
		User user = userService.findById(idUser);
		if (!user.getProfile().equals("admin")) {
			TimelapseExceptionHandler.notAllowed();
			;
		}
		this.timelapseService.deleteTimelapse(result);
	}

	// UPDATE A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Timelapse update(
			@PathVariable("id") Long id,
			@RequestBody Timelapse timelapse,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		if (!user.getProfile().equals("admin")) {
			TimelapseExceptionHandler.notAllowed();
			;
		}
		return this.timelapseService.updateTimelapse(id, timelapse);
	}

}
