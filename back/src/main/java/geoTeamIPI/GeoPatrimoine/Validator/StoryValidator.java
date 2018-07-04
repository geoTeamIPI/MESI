package geoTeamIPI.GeoPatrimoine.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.service.StoryService;


@Component
public class StoryValidator implements Validator{
	
	@Autowired
	StoryService storyService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Story.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
	
	}


}
