package ucb.locar.models;

import java.io.Serializable;
import java.sql.Date;

public class Aluguel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idAluguel;
	private double valorTotal;
	private Date dataRetirada;
	private Date dataDevolucao;
	private Cliente cliente;
	private Veiculo veiculo;
	private boolean retirado;
	
	public Aluguel() {}

	
	public int getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public boolean isRetirado() {
		return retirado;
	}


	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
}
