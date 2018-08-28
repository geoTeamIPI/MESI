package geoTeamIPI.GeoPatrimoine;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import geoTeamIPI.GeoPatrimoine.service.StoryService;

public class StoryServiceTest {

	@Autowired
	private StoryService storyService;

	private static final long nombreStory = 7;

	@Test
	public void TestCountAllStories() {
		long response = storyService.countAllStories();
		System.out.println(response);
		Assertions.assertThat(response).isEqualTo(nombreStory);
	}

}
