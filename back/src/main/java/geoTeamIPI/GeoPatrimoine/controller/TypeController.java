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

import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.exception.TypeExceptionHandler;
import geoTeamIPI.GeoPatrimoine.service.TypeService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@RestController
@RequestMapping("/types")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TypeController {

	@Autowired
	private TypeService typeService;

	@Autowired
	private UserService userService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// COUNT ALL TYPES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return typeService.countAllTypes();
	}

	// LIST ALL TYPES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Type> listAll() {
		return typeService.findAllTypes();
	}

	// LIST ALL TYPES TO APPROVE - ADMIN
	@RequestMapping(value = "/approve", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Type> listAllApprove() {
		return typeService.findAllTypesApprove();
	}

	// CREATE A TYPE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Type create(
			@RequestBody Type type,
			BindingResult result,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		return this.typeService.createType(type, user);
	}

	// DISPLAY A TYPE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Type display(@PathVariable(value = "id") Long id) {
		Type result = typeService.findById(id);
		return result;
	}

	// DELETE A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(
			@PathVariable("id") Long id,
			@RequestHeader(value = "idUser") Long idUser) {
		Type result = typeService.findById(id);
		User user = userService.findById(idUser);
		if (!user.getProfile().equals("admin")) {
			TypeExceptionHandler.notAllowed();
			;
		}
		this.typeService.deleteType(result);
	}

	// UPDATE A TIMELAPSE - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Type update(
			@PathVariable("id") Long id,
			@RequestBody Type type,
			@RequestHeader(value = "idUser") Long idUser) {
		User user = userService.findById(idUser);
		if (!user.getProfile().equals("admin")) {
			TypeExceptionHandler.notAllowed();
			;
		}
		return this.typeService.updateType(id, type);
	}

}
