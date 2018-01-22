package com.blackliao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blackliao.DAO.VoteDAO;
import com.blackliao.bean.Vote;
import com.blackliao.util.DBConnection;
import com.blackliao.util.Page;

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

	public int findAllCount() {
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM tb_vote";
		
		PreparedStatement ps = null;
		ResultSet result = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			
			if (result.next()) {				
				 count = result.getInt(1);
//				count ++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(result);
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
		return count;
	}
	
	public List<Vote> findAllVote (Page page) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM tb_vote LIMIT ?,?";
		PreparedStatement ps = null;
		ResultSet result = null;
		List<Vote> votes = new ArrayList<Vote>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page.getBeginIndex());
			ps.setInt(2, page.getEveryPage());
			result = ps.executeQuery();
			while (result.next()) {
				Vote vote = new Vote();
				vote.setVoteID(result.getInt(1));
				vote.setVoteName(result.getString(2));
				vote.setChannelID(result.getInt(3));
				votes.add(vote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(result);
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
		return votes;
	}

	public void deleteVote(int voteID) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM tb_vote WHERE vote_id=?";
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, voteID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
	}
	
	public int findCountByChannel(int channelID) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM tb_vote WHERE channel_id=?";
		
		PreparedStatement ps = null;
		ResultSet result = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, channelID);
			result = ps.executeQuery();
			if (result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(result);
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
		return count;
	}
	
	public List<Vote> findVoteByChannel(Page page, int channelID) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM tb_vote WHERE channel_id=? LIMIT ?,? ";
		PreparedStatement ps = null;
		ResultSet result = null;
		List<Vote> votes = new ArrayList<Vote>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, channelID);
			ps.setInt(2, page.getBeginIndex());
			ps.setInt(3, page.getEveryPage());
			result = ps.executeQuery();
			while (result.next()) {
				Vote vote = new Vote();
				vote.setVoteID(result.getInt(1));
				vote.setVoteName(result.getString(2));
				vote.setChannelID(result.getInt(3));
				votes.add(vote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(result);
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
		return votes;
		
	}
	
	public Vote findVoteByID(int voteID) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM tb_vote WHERE vote_id=? ";
		PreparedStatement ps = null;
		ResultSet result = null;
		Vote vote = new Vote();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, voteID);
			result = ps.executeQuery();
			while (result.next()) {
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
