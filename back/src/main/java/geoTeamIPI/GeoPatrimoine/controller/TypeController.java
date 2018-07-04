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

import geoTeamIPI.GeoPatrimoine.entity.Type;
import geoTeamIPI.GeoPatrimoine.service.TypeService;

@RestController
@RequestMapping("/types")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TypeController {

	@Autowired
	private TypeService typeService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// COUNT ALL PLACES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return typeService.countAllTypes();
	}

	// LIST ALL PLACES - ADMIN AND USER MODES
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public List<Type> listAll() {
		return typeService.findAllTypes();
	}

	// LIST ALL PLACES WITH PAGINATION - ADMIN AND USER MODES
	@RequestMapping(value = "/pagin", method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Page<Type> listAllPagination(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("sortProperty") String sortProperty, @RequestParam("sortDirection") String sortDirection) {
		Page<Type> pagin = typeService.findAllTypes(page, size, sortProperty, sortDirection);
		return pagin;
	}

	// CREATE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Type create(@RequestBody Type type, BindingResult result) {
		return this.typeService.createType(type);
	}

	// DISPLAY A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/display/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	public Type display(@PathVariable(value = "id") Long id) {
		Type result = typeService.findById(id);
		return result;
	}

	// DELETE A PLACE - ADMIN AND USER MODES
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		Type result = typeService.findById(id);
		this.typeService.deleteType(result);
	}

	// UPDATE A PLACEs - ADMIN AND USER MODES
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Type update(@PathVariable("id") Long id, @RequestBody Type type) {
		return this.typeService.updateType(id, type);
	}

}
