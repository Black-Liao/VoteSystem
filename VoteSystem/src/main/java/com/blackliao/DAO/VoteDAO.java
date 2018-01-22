package com.blackliao.DAO;

import java.util.List;

import com.blackliao.bean.Vote;
import com.blackliao.util.Page;

public interface VoteDAO {

	void addVote(Vote vote);
	
	Vote findVoteByName(String name);
	
	int findAllCount();
	
	List<Vote> findAllVote(Page page);
	
	void deleteVote(int voteID);
	
	int findCountByChannel(int channelID);
	
	List<Vote> findVoteByChannel(Page page, int channelID);
	
	Vote findVoteByID(int VoteID);
}
