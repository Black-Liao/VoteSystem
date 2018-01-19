package com.blackliao.factory;

import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.DAOImpl.VoteOptionDAOImpl;

public class VoteOptionFactory {

	public static VoteOptionDAO getVoteOptionDAOInstance () {
		return new VoteOptionDAOImpl();
	}
	
}
