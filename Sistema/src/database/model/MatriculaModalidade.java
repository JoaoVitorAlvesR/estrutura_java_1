package database.model;

import java.sql.Date;

public class MatriculaModalidade {
	
	private int codigoMatricula;
	private String modalidade;
	private String graduacao;
	private String plano;
	private Date dataInicio;
	private Date dataFim;
	
	public MatriculaModalidade() {
		
	}
	


	public MatriculaModalidade(int codigoMatricula, String modalidade, String graduacao, String plano, Date dataInicio, Date dataFim) {
		this.codigoMatricula = codigoMatricula;
		this.modalidade = modalidade;
		this.graduacao = graduacao;
		this.plano = plano;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}



	public int getCodigoMatricula() {
		return codigoMatricula;
	}



	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}



	public String getModalidade() {
		return modalidade;
	}



	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}



	public String getGraduacao() {
		return graduacao;
	}



	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}



	public String getPlano() {
		return plano;
	}



	public void setPlano(String plano) {
		this.plano = plano;
	}



	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}



	public Date getDataFim() {
		return dataFim;
	}



	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
