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

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.service.StoryService;

@RestController
@RequestMapping("/stories")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class StoryController {

	@Autowired
	private StoryService storyService;

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

	// TO DO LIST
	// - Generer toutes les requetes necessaires de base (cf mdd050 par exemple ==> crud + count + findby
	// - Reflechir a des requetes plus spécifiques qui repondent aux besoins du métier (regarder notamment les variables de l'entité et ce qui
	// pourrait etre necessaire de faire)
	// - Mettre en place les requetes specifiques à un user : ex : Count all stories of a user
	// - Mettre en place les validations de champs ==> @Autowired private StoryValidator storyValidator
	// - Avoir la gestion des erreurs : badrequest, ... comme fait en mdd050
	// - Avoir le postman pour chaque requete + le fichier excel complété
	// - Modifier le service pour que les différentes fonctions entrainent bien les specificites particulieres : par exemple create doit remplir
	// automatiquement la date par la date du jour ou update doit mettre a jour la date de dernier update sauf si aucune modifcation n a ete
	// faite
	// - Create stories : necessite dans le service de dire que l'id est celui de l'utilisateur connecté.
	// - update a story : on ne peut pas modifier une story de quelqu un d autre (sauf si admin)
	// - delete a story : on ne peut pas supprimer une story de quelqu un d autre (sauf si admin)
	// - Changer les noms des methodes de Cedric pour qu'elles soient uniformes avec les miennes
	// - verifier ce que Cedric a fait dans user et que se soit bien homogene entre les 2 (notamment il manque count, egalement les url des
	// appels doivent etre uniformes, ...)
	// - prevoir suppression compte : les stories du user sont attribuées à un user deletedUser

	// COUNT ALL STORIES - ADMIN AND USER MODES
	@GetMapping("/count")
	public Long countAll() {
		return storyService.countAllStories();
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

	// CREATE A STORY - ADMIN AND USER MODES
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
	public Story create(@RequestBody Story story, BindingResult result) {
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
