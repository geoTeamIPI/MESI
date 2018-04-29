package geoTeamIPI.GeoPatrimoine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.service.StoryService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
/*
	@Autowired
	private UserService userService;
	
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET)
	public String detailStory(@PathVariable(value="id") Long id , Map<String,Object> model) {
		User user = userService.findById(id);
		model.put("user", user);
		return "users/detail";
	}
	 
	 @RequestMapping (
			 value = "",
			 method = RequestMethod.GET,
			 params={"page", "size", "sortProperty", "sortDirection"}
			 )	 
	 public String afficheListeUsers(Map<String,Object> model,
			 @RequestParam("page") Integer page,
			 @RequestParam("size") Integer size,
			 @RequestParam("sortProperty") String sortProperty,
			 @RequestParam("sortDirection") String sortDirection) {
		 Page<User> pagin = userService.findAllUsers(page, size, sortProperty, sortDirection);
		 model.put("pagination", pagin);
		 model.put("listePagination", pagin.getContent());
		 model.put("hasNext", pagin.hasNext());
		 model.put("hasPrevious", pagin.hasPrevious());
		 model.put("start", page*size + 1);
		 model.put("end", Math.min(page*size + size, pagin.getTotalElements()));
		 model.put("total", pagin.getTotalElements());
		 model.put("pageActuel", page + 1);
		 model.put("sizeActuel", size);
		 model.put("sortPropertyActuel", sortProperty);
		 model.put("sortDirectionActuel", sortDirection);
		 model.put("nextPage", page+1);
		 model.put("previousPage", page-1);
		 return "users/liste";
		 }
		*/ 
}
