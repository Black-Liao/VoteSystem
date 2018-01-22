package com.blackliao.action;

import java.util.List;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.VoteOption;
import com.blackliao.factory.VoteDAOFactory;
import com.blackliao.factory.VoteOptionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteVoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int voteID;
	
	public int getVoteID() {
		return voteID;
	}
	
	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
	
	public String execute() throws Exception {
		
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
		for (VoteOption voteOption : voteOptions) {
			voteOptionDAO.deleteVoteOption(voteOption.getVoteOptionID());
		}
		
		voteDAO.deleteVote(voteID);
		
		return SUCCESS;
		
	}
	
}
