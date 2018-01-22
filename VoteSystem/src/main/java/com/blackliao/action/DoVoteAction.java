package com.blackliao.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.VoteOption;
import com.blackliao.factory.VoteOptionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class DoVoteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int voteOptionID;
	private String otherOption;
	private int voteID;
	private int channelID;

	public int getVoteOptionID() {
		return voteOptionID;
	}

	public void setVoteOptionID(int voteOptionID) {
		this.voteOptionID = voteOptionID;
	}

	public String getOtherOption() {
		return otherOption;
	}

	public void setOtherOption(String otherOption) {
		this.otherOption = otherOption;
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public String execute() throws Exception {

		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		Cookie cookies[] = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getValue().equals(Integer.toString(voteID))) {
				this.addActionError("You vote today,please tomorrow vote again");
				return INPUT;
			}
		}
		if (voteOptionID == 0) {
			VoteOption voteOption = new VoteOption();
			voteOption.setVoteID(voteID);
			voteOption.setVoteOptionName(otherOption);
			voteOption.setTicketNum(1);
			voteOptionDAO.addVoteOption(voteOption);
		} else {
			VoteOption voteOption = voteOptionDAO.findVoteOptionByID(voteOptionID);
			voteOption.setTicketNum(voteOption.getTicketNum() + 1);
			voteOptionDAO.updateVoteOption(voteOption);
			Cookie cookie = new Cookie("hasVote" + voteID, Integer.toString(voteID));
			ServletActionContext.getResponse().addCookie(cookie);
		}
		
		return SUCCESS;
	}

}
