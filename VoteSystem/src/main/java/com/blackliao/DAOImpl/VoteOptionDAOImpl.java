package com.blackliao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blackliao.DAO.VoteOptionDAO;
import com.blackliao.bean.VoteOption;
import com.blackliao.util.DBConnection;

public class VoteOptionDAOImpl implements VoteOptionDAO {

	public void addVoteOption(VoteOption voteOption) {
		
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO tb_voteoption(voteoption_name,vote_id,ticket_num) value(?,?,?)";
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, voteOption.getVoteOptionName());
			ps.setInt(2, voteOption.getVoteID());
			ps.setInt(3, voteOption.getTicketNum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
	}

	public List<VoteOption> findVoteOptionByVoteID(int voteID) {
		
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM tb_voteoption WHERE vote_id=?";
		
		PreparedStatement ps = null;
		ResultSet result = null;
		List<VoteOption> voteOptions = new ArrayList<VoteOption>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, voteID);
			result = ps.executeQuery();
			while (result.next()) {
				VoteOption vo = new VoteOption();
				vo.setVoteOptionID(result.getInt(1));
				vo.setVoteOptionName(result.getString(2));
				vo.setVoteID(result.getInt(3));
				vo.setTicketNum(result.getInt(4));
				voteOptions.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voteOptions;
	}
	
	public void deleteVoteOption(int voteOptionID) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM tb_voteoption WHERE voteoption_id=?";
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, voteOptionID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(ps);
			DBConnection.close(conn);
		}
		
	}

}
