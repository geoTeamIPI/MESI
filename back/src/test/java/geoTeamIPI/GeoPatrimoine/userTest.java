package geoTeamIPI.GeoPatrimoine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import geoTeamIPI.GeoPatrimoine.controller.UserController;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class userTest {
	
	@Mock
	UserService userService; 
	
	@Mock
	BindingResult result;
	
	@InjectMocks
	UserController userController; 

	private MockMvc mock; 
	
	@Before
	public void setUp() {
		final UserController userController = new UserController(); 
		mock = MockMvcBuilders.standaloneSetup(userController).build(); 
				
	}
	
	// Add a user
	
	// Test -> All fields required are null or empty
	@Test
	public void AllFieldsRequiredNullOrEmpty() {
		// To do 
	}
	
	@Test
	// Test -> The two passwords are not equals
	public void PasswordsAreNotEquals() {
		// To do 
	}
	

}
