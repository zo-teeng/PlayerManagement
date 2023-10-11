package Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConnection;

public class PlayerDAO extends DBConnection{
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public ArrayList<Player> getPlayerList() {
		
		ArrayList<Player> playerList = new ArrayList<>();
		
		try {
			conn = getConnection();

			stmt= conn.createStatement();
			rs=stmt.executeQuery("select * from player");

			while(rs.next()) {
				Player user = new Player(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				playerList.add(user);
				
			}
			close();
		}catch(Exception e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}
		
		return playerList;
		
	}
	
	public void insertPlayer(Player player) {
		
		conn = getConnection();

		String sql="insert into player values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getBackNum());
			pstmt.setString(2, player.getName());
			pstmt.setString(3, player.getAge());
			pstmt.setString(4, player.getHeight());
			pstmt.setString(5, player.getWeight());
			pstmt.setString(6, player.getPosition());

			pstmt.executeUpdate();
			
			System.out.println("등록성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}
	
	public void deletePlayer(Player player) {
		
		conn = getConnection();

		String sql="delete from player where backNum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getBackNum());

			pstmt.executeUpdate();
			
			System.out.println("삭제성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}
	
	public void updatePlayer(Player player, String backNum, String name) {
		
		conn = getConnection();

		String sql="update player set backNum=?,name=?,age=?,height=?,weight=?,position=? where backNum=? and name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getBackNum());
			pstmt.setString(2, player.getName());
			pstmt.setString(3, player.getAge());
			pstmt.setString(4, player.getHeight());
			pstmt.setString(5, player.getWeight());
			pstmt.setString(6, player.getPosition());
			pstmt.setString(7, backNum);
			pstmt.setString(8, name);

			pstmt.executeUpdate();
			
			System.out.println("등록성공");

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
