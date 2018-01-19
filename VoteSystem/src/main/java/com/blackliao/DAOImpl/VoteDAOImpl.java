package com.blackliao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.bean.Vote;
import com.blackliao.util.DBConnection;

public class VoteDAOImpl implements VoteDAO {

	public void addVote(Vote vote) {
		Connection conn = DBConnection.getConnection();
		
		String sql = "INSERT INTO tb_vote(vote_name, channel_ID) VALUE(?, ?)";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vote.getVoteName());
			ps.setInt(2, vote.getChannelID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
	}

	public Vote findVoteByName(String name) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "select * from tb_vote as v where v.vote_name = ?";
		PreparedStatement ps = null;
		ResultSet result = null;
		Vote vote = new Vote();
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			result = ps.executeQuery();
			if (result.next()) {
				vote.setVoteID(result.getInt(1));
				vote.setVoteName(result.getString(2));
				vote.setChannelID(result.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(result);
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
		return vote;
	}

}
