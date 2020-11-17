package ucb.locar.models;

import java.io.Serializable;
import java.sql.Date;

public class Rent implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private double totalValue;
	private Date pickupDate;
	private Date dropoffDate;
	private User user;
	private Vehicle vehicle;
	
	public Rent() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getDropoffDate() {
		return dropoffDate;
	}

	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
