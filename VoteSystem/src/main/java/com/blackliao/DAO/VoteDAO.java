package com.blackliao.DAO;

import com.blackliao.bean.Vote;

public interface VoteDAO {

	void addVote(Vote vote);
	
	Vote findVoteByName(String name);
	
}
