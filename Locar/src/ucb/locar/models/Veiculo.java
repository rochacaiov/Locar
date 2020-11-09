package ucb.locar.models;

import java.io.Serializable;
import java.time.Year;

public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idVeiculo;
	private String placa;
	private String marca;
	private String modelo;
	private Year ano;
	private double valor;

	public Veiculo() {}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
