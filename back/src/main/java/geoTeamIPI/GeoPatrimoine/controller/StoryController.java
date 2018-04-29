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
@RequestMapping("/stories")
public class StoryController {
	/* LUDOVIC TESTING 
	@Autowired
	private StoryService storyService;
	
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET)
	public String detailStory(@PathVariable(value="id") Long id , Map<String,Object> model) {
		Story story = storyService.findById(id);
		model.put("story", story);
		return "stories/detail";
	}
	 
	 @RequestMapping (
			 value = "",
			 method = RequestMethod.GET,
			 params={"page", "size", "sortProperty", "sortDirection"}
			 )	 
	 public String afficheListeStories(Map<String,Object> model,
			 @RequestParam("page") Integer page,
			 @RequestParam("size") Integer size,
			 @RequestParam("sortProperty") String sortProperty,
			 @RequestParam("sortDirection") String sortDirection) {
		 Page<Story> pagin = storyService.findAllStories(page, size, sortProperty, sortDirection);
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
		 return "stories/liste";
		 }
	 
	    /*@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
        public RedirectView supprimeEmploye(@PathVariable(value = "id") Long id, RedirectAttributes attributes) {
            employeService.deleteEmploye(id);
    
            //on initialise des valeurs nécessaires pour appeler la méthode afficheListeEmployes
            attributes.addAttribute("page", 0);
            attributes.addAttribute("size", 10);
            attributes.addAttribute("sortProperty", "matricule");
            attributes.addAttribute("sortDirection", "ASC");
            //message qui sera affichée dans le header
            attributes.addAttribute("success", "suppression réussie");
    
            return new RedirectView("/employes");
        }
	    
	    @RequestMapping(
	    		value = "/new/commercial",
	    		method = RequestMethod.GET
	    		)
	    	
	    public String nouveauCommercial(Map<String, Object> model) {
	    	model.put("employe", new Commercial());
	    	return "/employes/detail";
	    	}
	    
	    @RequestMapping(
	    		value = "/new/technicien",
	    		method = RequestMethod.GET
	    		)
	    public String nouveauTechnicien(Map<String, Object> model) {
	    	model.put("employe", new Technicien());
	    	return "/employes/detail";
	    	}
	    
	    @RequestMapping(
	    		value = "/new/manager",
	    		method = RequestMethod.GET
	    		)
	    public String nouveauManager(Map<String, Object> model) {
	    	model.put("employe", new Manager());
	    	return "/employes/detail";
	    	}*/

}
