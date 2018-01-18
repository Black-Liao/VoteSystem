package com.blackliao.factory;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.DAOImpl.VoteDAOImpl;

public class VoteDAOFactory {

	public static VoteDAO getVoteDAOInstance() {
		return new VoteDAOImpl();
	}
	
}
