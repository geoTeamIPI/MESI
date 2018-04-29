package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="STORIES")
public class Story {

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Integer starting_year;
    
    @Column
    private Integer starting_month;
    
    @Column
    private Integer starting_day;
    
    @Column
    private Integer ending_year;
    
    @Column
    private Integer ending_month;
    
    @Column
    private Integer ending_day;
    
    @Column(nullable=false)
    private LocalDate date_creation;
    
    @Column
    private LocalDate date_update;
    
    @ManyToOne
    private User creatorUser;
    
    @ManyToOne
    private Place place;
    
    @OneToOne
    private Type type;
    
    @OneToMany(mappedBy = "story")
    private Collection<Media> media;
    
    @OneToMany(mappedBy = "votedStory")
    private Collection<Vote> votes;

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
		return starting_year;
	}

	public void setStarting_year(Integer starting_year) {
		this.starting_year = starting_year;
	}

	public Integer getStarting_month() {
		return starting_month;
	}

	public void setStarting_month(Integer starting_month) {
		this.starting_month = starting_month;
	}

	public Integer getStarting_day() {
		return starting_day;
	}

	public void setStarting_day(Integer starting_day) {
		this.starting_day = starting_day;
	}

	public Integer getEnding_year() {
		return ending_year;
	}

	public void setEnding_year(Integer ending_year) {
		this.ending_year = ending_year;
	}

	public Integer getEnding_month() {
		return ending_month;
	}

	public void setEnding_month(Integer ending_month) {
		this.ending_month = ending_month;
	}

	public Integer getEnding_day() {
		return ending_day;
	}

	public void setEnding_day(Integer ending_day) {
		this.ending_day = ending_day;
	}

	public LocalDate getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}

	public LocalDate getDate_update() {
		return date_update;
	}

	public void setDate_update(LocalDate date_update) {
		this.date_update = date_update;
	}

	public User getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
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

	public Collection<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
    
    
}
