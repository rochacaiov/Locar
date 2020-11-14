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
	private boolean pickedUp;
	
	public Rent() {}

	
	public int getId() {
		return id;
	}

	public void setId(int idAluguel) {
		this.id = idAluguel;
	}

	public double getValorTotal() {
		return totalValue;
	}

	public void setValorTotal(double valorTotal) {
		this.totalValue = valorTotal;
	}

	public Date getDataRetirada() {
		return pickupDate;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.pickupDate = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dropoffDate;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dropoffDate = dataDevolucao;
	}

	public User getCliente() {
		return user;
	}

	public void setCliente(User cliente) {
		this.user = cliente;
	}

	public Vehicle getVeiculo() {
		return vehicle;
	}

	public void setVeiculo(Vehicle veiculo) {
		this.vehicle = veiculo;
	}


	public boolean isRetirado() {
		return pickedUp;
	}


	public void setRetirado(boolean retirado) {
		this.pickedUp = retirado;
	}
}
