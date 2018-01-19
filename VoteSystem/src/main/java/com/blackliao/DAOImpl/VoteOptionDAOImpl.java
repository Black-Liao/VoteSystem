package com.blackliao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
