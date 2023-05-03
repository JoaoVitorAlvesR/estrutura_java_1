package database.model;

import java.sql.Timestamp;

import database.StatusPagamento;

public class Pagamento {
	private Integer codigoMatricula;
	private Timestamp dataVencimento;
	private Double valor;
	private Timestamp dataPagamento;
	private Timestamp dataCancelamento;
	private StatusPagamento status;

	public Pagamento(Integer codigoMatricula, Timestamp dataVencimento, Timestamp dataPagamento,
			Timestamp dataCancelamento, Double valor, StatusPagamento status) {
		this.codigoMatricula = codigoMatricula;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataCancelamento = dataCancelamento;
		this.status = status;
	}

	public Pagamento() {

	}

	public Integer getCodigoMatricula() {
		return codigoMatricula;
	}

	public void setCodigoMatricula(Integer codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public Timestamp getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Timestamp dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Timestamp getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Timestamp dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Timestamp getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Timestamp dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	}
}