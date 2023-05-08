package database.model;

import java.util.Date;

public class MatriculaModel {
	
	private int codigo_matricula;
	private int codigo_aluno;
	private Date data_matricula;
	private int dia_vencimento;
	private Date dia_encerramento;
	
	public MatriculaModel(int codigo_matricula, int codigo_aluno, Date data_matricula, int dia_vencimento,
			Date dia_encerramento) {
		this.codigo_matricula = codigo_matricula;
		this.codigo_aluno = codigo_aluno;
		this.data_matricula = data_matricula;
		this.dia_vencimento = dia_vencimento;
		this.dia_encerramento = dia_encerramento;
	}
	
	public MatriculaModel(int codigo_aluno) {
		this.codigo_aluno = codigo_aluno;
	}
	
	public MatriculaModel() {}
	
	public Date getData_matricula() {
		return data_matricula;
	}
	public void setMatricula(Integer codigo_matricula) {
		this.codigo_matricula = codigo_matricula;
	}
	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}
	public int getDia_vencimento() {
		return dia_vencimento;
	}
	public void setDia_vencimento(int dia_vencimento) {
		this.dia_vencimento = dia_vencimento;
	}
	public Date getDia_encerramento() {
		return dia_encerramento;
	}
	public void setDia_encerramento(Date dia_encerramento) {
		this.dia_encerramento = dia_encerramento;
	}
	public int getCodigo_matricula() {
		return codigo_matricula;
	}
	public int getCodigo_aluno() {
		return codigo_aluno;
	}
	public void setCodigo_aluno(Integer codigo_aluno) {
		this.codigo_aluno = codigo_aluno;
	}

	@Override
	public String toString() {
		return "MatriculaModel [codigo_matricula=" + codigo_matricula + ", codigo_aluno=" + codigo_aluno
				+ ", data_matricula=" + data_matricula + ", dia_vencimento=" + dia_vencimento + ", dia_encerramento="
				+ dia_encerramento + "]";
	}

	
	
	

}
