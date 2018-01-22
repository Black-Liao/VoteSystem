package com.blackliao.action;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.Vote;
import com.blackliao.bean.VoteOption;
import com.blackliao.factory.VoteDAOFactory;
import com.blackliao.factory.VoteOptionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class VoteResultAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int voteID;
	private JFreeChart chart;

	public JFreeChart getChart() {

		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionFactory.getVoteOptionDAOInstance();
		
		Vote vote = voteDAO.findVoteByID(voteID);
		String voteName = vote.getVoteName();
		
		List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		for (VoteOption voteOption : voteOptions) {
			dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
		}
		JFreeChart chart = ChartFactory.createBarChart3D(voteName, "Vote Option", "Ticket Number", dcd, PlotOrientation.VERTICAL, false, true, false);
		
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

}
