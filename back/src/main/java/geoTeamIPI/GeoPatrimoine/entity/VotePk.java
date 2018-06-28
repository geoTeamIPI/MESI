package geoTeamIPI.GeoPatrimoine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VotePk implements Serializable {

	@Column(name = "VOTER_ID")
	private Long voter_id;

	@Column(name = "VOTEDSTORY_ID")
	private Long votedStory_id;

	public Long getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Long voter_id) {
		this.voter_id = voter_id;
	}

	public Long getVotedStory_id() {
		return votedStory_id;
	}

	public void setVotedStory_id(Long votedStory_id) {
		this.votedStory_id = votedStory_id;
	}

}
