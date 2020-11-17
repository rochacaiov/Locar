package ucb.locar.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import ucb.locar.models.Rent;
import ucb.locar.models.Vehicle;

public class VehicleDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public VehicleDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public int update(Vehicle vehicle) throws SQLException {
		if (vehicle == null) return 0;
		
		String sql="UPDATE vehicle SET available=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setLong(2, vehicle.getId());
		
		stmt.setBoolean(1, vehicle.isAvailable());
	
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
	
	public Vehicle findById(int id) {
		String sql = "SELECT * FROM vehicle WHERE id=?";
		PreparedStatement stmt;
		Vehicle vehicle = new Vehicle();
		
		try {
			stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				vehicle.setId(rs.getLong("id"));
				vehicle.setPeople(rs.getInt("people"));
				vehicle.setVelocity(rs.getLong("velocity"));
				vehicle.setPower(rs.getLong("power"));
				vehicle.setPlate(rs.getString("plate"));
				vehicle.setModel(rs.getString("model"));
				vehicle.setProducer(rs.getString("producer"));
				vehicle.setYear(Year.of(rs.getInt("year")));
				vehicle.setValuePerDay(rs.getDouble("value_day"));
				vehicle.setAvailable(rs.getBoolean("available"));

				rs.close();
				stmt.close();
				return vehicle;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Vehicle> findAll() throws SQLException {
		String sql = "SELECT * FROM vehicle";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while (rs.next()) {
			Vehicle vehicle = new Vehicle();
			
			vehicle.setId(rs.getLong("id"));
			vehicle.setPeople(rs.getInt("people"));
			vehicle.setVelocity(rs.getLong("velocity"));
			vehicle.setPower(rs.getLong("power"));
			vehicle.setPlate(rs.getString("plate"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setProducer(rs.getString("producer"));
			vehicle.setYear(Year.of(rs.getInt("year")));
			vehicle.setValuePerDay(rs.getDouble("value_day"));
			vehicle.setAvailable(rs.getBoolean("available"));

			vehicles.add(vehicle);
		}
		rs.close();
		stmt.close();
		return vehicles;
	}

}
