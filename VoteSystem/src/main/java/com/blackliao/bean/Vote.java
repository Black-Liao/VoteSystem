package com.blackliao.bean;

public class Vote {

	private int voteID;
	private String voteName;
	private int channelID;

	@Override
	public String toString() {
		return "Vote [voteID=" + voteID + ", voteName=" + voteName + ", channelID=" + channelID + "]";
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	
}
