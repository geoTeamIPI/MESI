package geoTeamIPI.GeoPatrimoine.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Users")
public class User {

	public interface RequiredPassword {
	};

	public interface RequiredCity {
	};

	public interface requiredAllFields {
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	@Size(min = 3)
	@Email
	private String email;

	@NotBlank(groups = { RequiredPassword.class, requiredAllFields.class })
	@Column(nullable = false)
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

	@NotBlank
	@Column(nullable = false)
	private String city;

	@NotBlank
	@Column(nullable = false)
	private String profile;

	/*
	 * @OneToMany(mappedBy = "creatorUser") private Collection<Story> stories;
	 */

	@OneToMany(mappedBy = "voter")
	@JsonIgnore
	private Collection<Vote> storyAssoc;

	/**
	 * ------------------------------------ GETTERS AND SETTERS---------------------------
	 */

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

	/**
	 * public Collection<Story> getStories() { return stories; }
	 * 
	 * public void setStories(Collection<Story> stories) { this.stories = stories; }
	 */

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Collection<Vote> getStoryAssoc() {
		return storyAssoc;
	}

	public void setStoryAssoc(Collection<Vote> storyAssoc) {
		this.storyAssoc = storyAssoc;
	}

	/**
	 * ------------------------------------ PREVIOUS MODEL ---------------------------
	 */

	/**
	 * @OneToMany(mappedBy = "voter") @JsonIgnoreProperties("voter") private Collection<Vote> votes;
	 */

	/**
	 * public Collection<Vote> getVotes() { return votes; }
	 * 
	 * public void setVotes(Collection<Vote> votes) { this.votes = votes; }
	 */
}
