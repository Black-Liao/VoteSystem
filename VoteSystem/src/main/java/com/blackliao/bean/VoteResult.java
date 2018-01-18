package com.blackliao.bean;

import java.util.List;

public class VoteResult {

	private Vote vote;
	private List<VoteOption> votesOptions;

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public List<VoteOption> getVotesOptions() {
		return votesOptions;
	}

	public void setVotesOptions(List<VoteOption> votesOptions) {
		this.votesOptions = votesOptions;
	}

	@Override
	public String toString() {
		return "VoteResult [vote=" + vote + ", votesOptions=" + votesOptions + "]";
	}

}
