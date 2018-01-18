package com.blackliao.bean;

public class VoteOption {

	private int voteOptionID;
	private String voteOptionName;
	private int voteID;
	private int ticketNum;

	@Override
	public String toString() {
		return "VoteOption [voteOptionID=" + voteOptionID + ", voteOptionName=" + voteOptionName + ", voteID=" + voteID
				+ ", ticketNum=" + ticketNum + "]";
	}

	public int getVoteOptionID() {
		return voteOptionID;
	}

	public void setVoteOptionID(int voteOptionID) {
		this.voteOptionID = voteOptionID;
	}

	public String getVoteOptionName() {
		return voteOptionName;
	}

	public void setVoteOptionName(String voteOptionName) {
		this.voteOptionName = voteOptionName;
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	
}
