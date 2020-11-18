package ucb.locar.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ucb.locar.exceptions.UserNotFoundException;
import ucb.locar.models.Rent;

public class RentDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public RentDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public int insert(Rent rent) {
		String sql="INSERT INTO rent (pickup, dropoff, total, user_id, vehicle_id) values (?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		if (rent != null) {
			try {
				stmt = con.prepareStatement(sql);
				stmt.setDate(1, new Date(rent.getPickupDate().getTime()));
				stmt.setDate(2, new Date(rent.getDropoffDate().getTime()));
				stmt.setDouble(3, rent.getTotalValue());
				stmt.setLong(5, rent.getUser().getId());
				stmt.setLong(6, rent.getVehicle().getId());
				
				int retorno = stmt.executeUpdate();
				stmt.close();
				return retorno;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return 0;
	}
	
	public int delete(Rent rent) throws SQLException {
		if (rent == null) return 0;
		
		String sql="DELETE FROM rent WHERE id=?";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setLong(1, rent.getId());
	
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
	
	public Rent findById(long id) throws UserNotFoundException {
		String sql = "SELECT * FROM user WHERE id=?";
		PreparedStatement stmt;
		Rent rent = new Rent();
		UserDAO userDAO = new UserDAO();
		VehicleDAO vehicleDAO = new VehicleDAO();
		
		try {
			stmt = this.con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				rent.setId(rs.getInt("id"));
				rent.setPickupDate(rs.getDate("pickup"));
				rent.setDropoffDate(rs.getDate("dropoff"));
				rent.setTotalValue(rs.getDouble("total"));
				rent.setUser(userDAO.findById(rs.getInt("user_id")));
				rent.setVehicle(vehicleDAO.findById(rs.getInt("vehicle_id")));
				
				rs.close();
				stmt.close();
				return rent;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Rent> findAll() throws SQLException, UserNotFoundException {
		String sql = "SELECT * FROM rent";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Rent> rents = new ArrayList<Rent>();
		UserDAO userDAO = new UserDAO();
		VehicleDAO vehicleDAO = new VehicleDAO();
		
		while (rs.next()) {
			Rent rent = new Rent();
			rent.setId(rs.getInt("id"));
			rent.setPickupDate(rs.getDate("pickup"));
			rent.setDropoffDate(rs.getDate("dropoff"));
			rent.setTotalValue(rs.getDouble("total"));
			rent.setUser(userDAO.findById(rs.getInt("user_id")));
			rent.setVehicle(vehicleDAO.findById(rs.getInt("vehicle_id")));
			rents.add(rent);
		}
		rs.close();
		stmt.close();
		return rents;
	}

}
