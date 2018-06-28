package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Votes")
public class Vote{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(nullable=false)
    private LocalDate date_creation;
    
    @Column
    private LocalDate date_update;
    
    @Column
	public Comment comment;
	
    /**
    @ManyToOne
    @JsonIgnore
    private User voter;
    */

    /**
    @ManyToOne
    @JsonIgnore
    private Story votedStory;
    */
    
    
    @Column(nullable=false)
    private Boolean value;

    /** 
     * ------------------------------------ GETTERS AND SETTERS---------------------------
     * */
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
	/**
	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}
	*/

	/**
	public Story getVotedStory() {
		return votedStory;
	}

	public void setVotedStory(Story votedStory) {
		this.votedStory = votedStory;
	}
	*/
	

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	} 
      
}
