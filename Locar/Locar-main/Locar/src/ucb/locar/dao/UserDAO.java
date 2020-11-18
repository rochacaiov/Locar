package ucb.locar.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ucb.locar.enums.PermissionEnum;
import ucb.locar.exceptions.UserNotFoundException;
import ucb.locar.models.User;

public class UserDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public UserDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public int insert(User user) {
		String sql="INSERT INTO cliente (username, password, cpf, address, birthday, permission) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		if (user != null) {
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getCpf());
				stmt.setString(4, user.getAddress());
				stmt.setDate(5, new Date(user.getBirthday().getTime()));
				stmt.setString(6, user.getPermission().toString());
				
				int retorno = stmt.executeUpdate();
				stmt.close();
				return retorno;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return 0;
	}
	
	public User findById(int id) throws UserNotFoundException {
		String sql = "SELECT * FROM user WHERE id=?";
		PreparedStatement stmt;
		User user = new User();
		
		try {
			stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCpf(rs.getString("cpf"));
				user.setAddress(rs.getString("address"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPermission(PermissionEnum.valueOf(rs.getString("permission")));
				
				rs.close();
				stmt.close();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UserNotFoundException();
	}
	
	public User findUserByAuth(String username, String password) throws UserNotFoundException {
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		PreparedStatement stmt;
		User user = new User();
		
		try {
			stmt = this.con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCpf(rs.getString("cpf"));
				user.setAddress(rs.getString("address"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPermission(PermissionEnum.valueOf(rs.getString("permission")));
				
				rs.close();
				stmt.close();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new UserNotFoundException();
	}

}
