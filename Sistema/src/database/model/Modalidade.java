package database.model;

public class Modalidade {
	String modalidade;
	Integer frequencia;
	Double valorMensal;
	
	public Modalidade() {
		
	}
	
	public Modalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public Modalidade(Integer frequencia) {
		this.frequencia = frequencia;
	}
	public Modalidade(Double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public Double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
}
