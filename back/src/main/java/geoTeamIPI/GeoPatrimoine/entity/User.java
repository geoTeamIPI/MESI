package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    @NotNull
    @Size(min=3)
    @Email
    private String email; 
    
    @NotNull
    @Column(nullable=false)
    private String password;
    
	@Transient
	private String passwordConfirm;
	
	@Transient
	private String oldPassword; 
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@NotNull
	@Column(nullable=false)
    private String city; 
    
    @Column(nullable=false)
    private String profile; 
    
    @OneToMany(mappedBy = "creatorUser")
    private Collection<Story> stories;
    
    @OneToMany(mappedBy = "voter")
    private Collection<Vote> votes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Collection<Story> getStories() {
		return stories;
	}

	public void setStories(Collection<Story> stories) {
		this.stories = stories;
	}

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}


	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
