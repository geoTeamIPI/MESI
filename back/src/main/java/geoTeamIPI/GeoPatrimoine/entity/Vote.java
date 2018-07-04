package geoTeamIPI.GeoPatrimoine.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Votes")
@IdClass(VoteId.class)
public class Vote {

	@EmbeddedId
	private VotePk id;

	@Id
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "voter_id", referencedColumnName = "id")
	private User voter;

	@Id
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "votedStory_id", referencedColumnName = "id")
	private Story votedStory;

	@Column(nullable = false)
	private LocalDate date_creation;

	@Column
	private LocalDate date_update;

	@Column
	public Comment comment;

	@Column(nullable = false)
	private Boolean value;

	/**
	 * ------------------------------------ GETTERS AND SETTERS---------------------------
	 */

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

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public VotePk getId() {
		return id;
	}

	public void setId(VotePk id) {
		this.id = id;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public Story getVotedStory() {
		return votedStory;
	}

	public void setVotedStory(Story votedStory) {
		this.votedStory = votedStory;
	}

	/**
	 * ------------------------------------ OLD MODEL ---------------------------
	 */

	/**
	 * @ManyToOne
	 * @JsonIgnore private User voter;
	 */

	/**
	 * @ManyToOne
	 * @JsonIgnore private Story votedStory;
	 */

	/**
	 * public User getVoter() { return voter; }
	 * 
	 * public void setVoter(User voter) { this.voter = voter; }
	 */

	/**
	 * public Story getVotedStory() { return votedStory; }
	 * 
	 * public void setVotedStory(Story votedStory) { this.votedStory = votedStory; }
	 */

}
