package com.blackliao.DAO;

import java.util.List;

import com.blackliao.bean.VoteOption;

public interface VoteOptionDAO {

	void addVoteOption(VoteOption voteOption);
	
	List<VoteOption> findVoteOptionByVoteID(int voteID);
	
	void deleteVoteOption(int voteOptionID);
}
