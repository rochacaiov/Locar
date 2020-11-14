package ucb.locar.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ucb.locar.exceptions.InvalidLoginException;
import ucb.locar.models.User;

public class UserDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public UserDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public int insert(User user) {
		String sql="INSERT INTO cliente (idCliente, nome, dataNascimento, cpf, endereco) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		if (user != null) {
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, user.getId());
				stmt.setString(2, user.getUsername());
				stmt.setDate(3, new Date(user.getBirthday().getTime()));
				stmt.setString(4, user.getCpf());
				stmt.setString(5, user.getAddress());
				
				int retorno = stmt.executeUpdate();
				stmt.close();
				return retorno;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return 0;
	}
	
	public User read(String username, String password) throws InvalidLoginException {
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
				user.setAddress(rs.getString("endereco"));
				user.setBirthday(rs.getDate("dataNascimento"));
				rs.close();
				stmt.close();
				return user;
			}
			throw new InvalidLoginException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
