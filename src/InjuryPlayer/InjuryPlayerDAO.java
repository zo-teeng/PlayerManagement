package InjuryPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConnection;

public class InjuryPlayerDAO extends DBConnection{
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public ArrayList<InjuryPlayer> getInjuryPlayerList() {
		
		ArrayList<InjuryPlayer> playerList = new ArrayList<>();
		
		try {
			conn = getConnection();

			stmt= conn.createStatement();
			rs=stmt.executeQuery("select * from injuryPlayer");

			while(rs.next()) {
				InjuryPlayer player = new InjuryPlayer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				playerList.add(player);
				
			}
			close();
		}catch(Exception e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}
		
		return playerList;
		
	}
	
	public void insertInjuryPlayer(InjuryPlayer injuryPlayer) {
		
		conn = getConnection();

		String sql="insert into InjuryPlayer values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, injuryPlayer.getBackNum());
			pstmt.setString(2, injuryPlayer.getName());
			pstmt.setString(3, injuryPlayer.getAge());
			pstmt.setString(4, injuryPlayer.getHeight());
			pstmt.setString(5, injuryPlayer.getWeight());
			pstmt.setString(6, injuryPlayer.getPosition());

			pstmt.executeUpdate();
			
			System.out.println("등록성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}
	
	public void deleteInjuryPlayer(InjuryPlayer injuryPlayer) {
		
		conn = getConnection();

		String sql="delete from injuryPlayer where backNum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, injuryPlayer.getBackNum());

			pstmt.executeUpdate();
			
			System.out.println("삭제성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();

		}catch(Exception e) {
			System.out.println("����� ����");
		}

	}

}
