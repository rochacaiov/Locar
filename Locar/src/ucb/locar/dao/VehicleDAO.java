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
	private static Connection con;
	
	public VehicleDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public static int update(Vehicle vehicle) throws SQLException {
		if (vehicle == null) return 0;
		
		String sql="UPDATE vehicle SET available=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setLong(2, vehicle.getId());
		
		stmt.setBoolean(1, vehicle.isAvailable());
	
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}
	
	public static int alter(Vehicle vehicle) throws SQLException {
		if (vehicle == null)
			return 0;
		String sql="UPDATE aluno SET ID=?, people=?, velocity=?, power=?, plate=?, model=?, producer=?, year=?, valuePerDay=?, available=?, plate=? idVehicle=? WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setLong(1, vehicle.getId());
		stmt.setInt(2, vehicle.getPeople());
		stmt.setLong(3, vehicle.getVelocity());
		stmt.setLong(4, vehicle.getPower());
		stmt.setString(5, vehicle.getPlate());
		stmt.setString(6, vehicle.getModel());	
		stmt.setString(6, vehicle.getProducer());
		java.sql.Date data = new java.sql.Date(vehicle.getYear().getValue());
		stmt.setDate(7, data);
		stmt.setDouble(8, vehicle.getValuePerDay());
		stmt.setBoolean(9, vehicle.isAvailable());
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}

	
	
	public List<Vehicle> list() throws SQLException {
		String sql = "SELECT * FROM vehicle";
		PreparedStatement stmt = this.con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Vehicle> alunos = new ArrayList<Vehicle>();
		VehicleDAO cursoDAO = new VehicleDAO();
		while (rs.next()) {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(rs.getLong("id"));
			vehicle.setPeople(rs.getInt("people"));
			vehicle.setVelocity(rs.getLong("velocity"));
			vehicle.setPower(rs.getLong("power"));
			vehicle.setPlate(rs.getString("plate"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setProducer(rs.getString("producer"));
			vehicle.setYear(rs.getYear("year"));
			vehicle.setValuePerDay(rs.getDouble("valuePerDay"));
			vehicle.setAvailable(rs.getBoolean("available"));
			
			vehicle.setVehicle(VehicleDAO.findAll(rs.getLong("id")));
			vehicle.add(vehicle);
		}
		rs.close();
		stmt.close();
			
			
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
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Vehicle> findAll(long id) throws SQLException {
		String sql = "SELECT * FROM vehicle";
		PreparedStatement stmt = con.prepareStatement(sql);
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
	
	public static int delete(Vehicle vehicle) throws SQLException {
		if (vehicle == null)
			return 0;
		String sql="DELETE FROM vehicle WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setLong(1, vehicle.getId());		
		int retorno = stmt.executeUpdate();
		stmt.close();
		return retorno;
	}

}
	

