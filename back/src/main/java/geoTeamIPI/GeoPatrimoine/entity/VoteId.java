package geoTeamIPI.GeoPatrimoine.entity;

import java.io.Serializable;

public class VoteId implements Serializable {

	private Long voter;
	private Long votedStory;

	public Long getVoter() {
		return voter;
	}

	public void setVoter(Long voter) {
		this.voter = voter;
	}

	public Long getVotedStory() {
		return votedStory;
	}

	public void setVotedStory(Long votedStory) {
		this.votedStory = votedStory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((votedStory == null) ? 0 : votedStory.hashCode());
		result = prime * result + ((voter == null) ? 0 : voter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteId other = (VoteId) obj;
		if (votedStory == null) {
			if (other.votedStory != null)
				return false;
		} else if (!votedStory.equals(other.votedStory))
			return false;
		if (voter == null) {
			if (other.voter != null)
				return false;
		} else if (!voter.equals(other.voter))
			return false;
		return true;
	}

}
