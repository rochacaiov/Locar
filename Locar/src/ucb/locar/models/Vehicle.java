package ucb.locar.models;

import java.io.Serializable;
import java.time.Year;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String plate;
	private String marca;
	private String model;
	private Year year;
	private double valuePerDay;

	public Vehicle() {}

	public int getId() {
		return id;
	}

	public void setId(int idVeiculo) {
		this.id = idVeiculo;
	}

	public String getPlaca() {
		return plate;
	}

	public void setPlaca(String placa) {
		this.plate = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return model;
	}

	public void setModelo(String modelo) {
		this.model = modelo;
	}

	public Year getAno() {
		return year;
	}

	public void setAno(Year ano) {
		this.year = ano;
	}

	public double getValor() {
		return valuePerDay;
	}

	public void setValor(double valor) {
		this.valuePerDay = valor;
	}
}
