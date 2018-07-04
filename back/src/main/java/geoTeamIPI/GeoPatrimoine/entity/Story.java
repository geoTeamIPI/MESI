package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "STORIES")
public class Story {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Lob
	@Column
	private String description;

	@Lob
	@Column
	private String content;

	@Column
	private Integer startingYear;

	@Column
	private Integer startingMonth;

	@Column
	private Integer startingDay;

	@Column
	private Integer endingYear;

	@Column
	private Integer endingMonth;

	@Column
	private Integer endingDay;

	@Column(nullable = false)
	private LocalDate dateCreation;

	@Column
	private LocalDate dateUpdate;

	@ManyToOne
	private User creator;

	@ManyToOne
	private Place place;

	@OneToOne
	private Type type;

	@OneToMany(mappedBy = "story")
	private Collection<Media> media;

	@OneToMany(mappedBy = "votedStory")
	@JsonIgnore
	private Collection<Vote> userAssoc;

	/**
	 * ------------------------------------ GETTERS AND SETTERS---------------------------
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(Integer startingYear) {
		this.startingYear = startingYear;
	}

	public Integer getStartingMonth() {
		return startingMonth;
	}

	public void setStartingMonth(Integer startingMonth) {
		this.startingMonth = startingMonth;
	}

	public Integer getStartingDay() {
		return startingDay;
	}

	public void setStartingDay(Integer startingDay) {
		this.startingDay = startingDay;
	}

	public Integer getEndingYear() {
		return endingYear;
	}

	public void setEndingYear(Integer endingYear) {
		this.endingYear = endingYear;
	}

	public Integer getEndingMonth() {
		return endingMonth;
	}

	public void setEndingMonth(Integer endingMonth) {
		this.endingMonth = endingMonth;
	}

	public Integer getEndingDay() {
		return endingDay;
	}

	public void setEndingDay(Integer endingDay) {
		this.endingDay = endingDay;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Collection<Media> getMedia() {
		return media;
	}

	public void setMedia(Collection<Media> media) {
		this.media = media;
	}

	public Collection<Vote> getUserAssoc() {
		return userAssoc;
	}

	public void setUserAssoc(Collection<Vote> userAssoc) {
		this.userAssoc = userAssoc;
	}

	public void setCreatorOpt(Optional<User> user) {
		// TODO Auto-generated method stub
	}

	/**
	 * ------------------------------------ PREVIOUS MODEL---------------------------
	 */

	/**
	 * @OneToMany(mappedBy = "votedStory") @JsonIgnoreProperties("votedStory") private Collection<Vote> votes;
	 */

	/**
	 * public Collection<Vote> getVotes() { return votes; }
	 * 
	 * public void setVotes(Collection<Vote> votes) { this.votes = votes; }
	 */

}
