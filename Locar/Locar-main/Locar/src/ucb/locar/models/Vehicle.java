package ucb.locar.models;

import java.io.Serializable;
import java.time.Year;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;	
	private long id;
	private int people;
	private long velocity;
	private long power;
	private String plate;
	private String model;
	private String producer;
	private Year year;
	private double valuePerDay;
	private boolean available;

	public Vehicle() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public long getVelocity() {
		return velocity;
	}

	public void setVelocity(long velocity) {
		this.velocity = velocity;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public double getValuePerDay() {
		return valuePerDay;
	}

	public void setValuePerDay(double valuePerDay) {
		this.valuePerDay = valuePerDay;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
