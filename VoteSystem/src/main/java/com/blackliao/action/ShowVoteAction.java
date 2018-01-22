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

public class ShowVoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public String execute() throws Exception {
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		
		int totalCount = voteDAO.findAllCount();
		currentPage = 1;
		Page page = PageUtil.createPage(10, totalCount, currentPage);
		List<Vote> votes = voteDAO.findAllVote(page);
		List<VoteResult> voteResultList = new ArrayList<VoteResult>();
		for (Vote vote : votes) {
			List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			VoteResult vr = new VoteResult();
			vr.setVote(vote);
			vr.setVotesOptions(voteOptions);
			voteResultList.add(vr);
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", voteResultList);
		request.setAttribute("page", page);
		
		return SUCCESS;
	}
	
	
}
