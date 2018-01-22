package com.blackliao.action;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.Vote;
import com.blackliao.bean.VoteOption;
import com.blackliao.factory.VoteDAOFactory;
import com.blackliao.factory.VoteOptionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class VoteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int channel;
	private String voteName;
	private String[] voteOption;
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public String[] getVoteOption() {
		return voteOption;
	}

	public void setVoteOption(String[] voteOption) {
		this.voteOption = voteOption;
	}

	public String execute() throws Exception {
		
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		
		Vote vote = new Vote();
		vote.setChannelID(channel);
		vote.setVoteName(voteName);
		
		voteDAO.addVote(vote);
		int voteID = voteDAO.findVoteByName(voteName).getVoteID();
		
		for (String voteOptionName : voteOption) {
			VoteOption vOption = new VoteOption();
			vOption.setVoteOptionName(voteOptionName);
			vOption.setVoteID(voteID);
			voteOptionDAO.addVoteOption(vOption);
		}
		
		return SUCCESS;
	}
	
}
