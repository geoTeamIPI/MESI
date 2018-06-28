package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="STORIES")
public class Story {

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
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
    
    @Column(nullable=false)
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
    
    /**
    @OneToMany(mappedBy = "votedStory")
    @JsonIgnoreProperties("votedStory")
    private Collection<Vote> votes;
    */
    
    /** 
     * ------------------------------------ GETTERS AND SETTERS---------------------------
     * */
    
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

	public Integer getStarting_year() {
		return startingYear;
	}

	public void setStarting_year(Integer starting_year) {
		this.startingYear = starting_year;
	}

	public Integer getStarting_month() {
		return startingMonth;
	}

	public void setStarting_month(Integer starting_month) {
		this.startingMonth = starting_month;
	}

	public Integer getStarting_day() {
		return startingDay;
	}

	public void setStarting_day(Integer starting_day) {
		this.startingDay = starting_day;
	}

	public Integer getEnding_year() {
		return endingYear;
	}

	public void setEnding_year(Integer ending_year) {
		this.endingYear = ending_year;
	}

	public Integer getEnding_month() {
		return endingMonth;
	}

	public void setEnding_month(Integer ending_month) {
		this.endingMonth = ending_month;
	}

	public Integer getEnding_day() {
		return endingDay;
	}

	public void setEnding_day(Integer ending_day) {
		this.endingDay = ending_day;
	}

	public LocalDate getDate_creation() {
		return dateCreation;
	}

	public void setDate_creation(LocalDate date_creation) {
		this.dateCreation = date_creation;
	}

	public LocalDate getDate_update() {
		return dateUpdate;
	}

	public void setDate_update(LocalDate date_update) {
		this.dateUpdate = date_update;
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
	
	/**
	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
	*/

}
