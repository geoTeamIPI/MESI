package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MEDIA")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column
    private String comment;
    
    @Lob
    @Column(nullable=false)
    private String path;
    
    @ManyToOne
    @JsonIgnore
    private Story story;
    
    @Column(nullable=false)
    private LocalDate date_creation;
    
    @Column
    private LocalDate date_update;
    
    /** 
     * ------------------------------------ GETTERS AND SETTERS---------------------------
     * */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
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
}
