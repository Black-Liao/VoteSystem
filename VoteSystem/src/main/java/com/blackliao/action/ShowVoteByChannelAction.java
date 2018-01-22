package com.blackliao.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.Vote;
import com.blackliao.bean.VoteOption;
import com.blackliao.bean.VoteResult;
import com.blackliao.factory.VoteDAOFactory;
import com.blackliao.factory.VoteOptionFactory;
import com.blackliao.util.Page;
import com.blackliao.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ShowVoteByChannelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int channelID;
	private int currentPage;
	public int getChannelID() {
		return channelID;
	}
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String execute() throws Exception {
		
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		
		int totalCount = voteDAO.findCountByChannel(channelID);
		Page page = PageUtil.createPage(3, totalCount, currentPage);
		List<Vote> votes = voteDAO.findVoteByChannel(page, channelID);
		List<VoteResult> voteResults = new ArrayList<VoteResult>();
		for (Vote vote : votes) {
			VoteResult voteResult = new VoteResult();	
			voteResult.setVote(vote);
			List<VoteOption> votesOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			voteResult.setVotesOptions(votesOptions);
			voteResults.add(voteResult);
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResults", voteResults);
		request.setAttribute("page", page);
		
		return SUCCESS;
	}

}
