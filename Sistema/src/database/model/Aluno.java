package database.model;

import java.sql.Date;

public class Aluno {

	private int codigo_aluno;
	private String aluno;
	private String data_nascimento;
	private String sexo;
	private String telefone;
	private String cpf;
	private String celular;
	private String email;
	private String observacao;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;
	
	
public Aluno() {
		
	}

	public Aluno(
			final int codigo_aluno, final String aluno, final String data_nascimento, final String sexo,
			final String telefone, final String cpf, final String celular, final String email, final String observacao,
			final String endereco, final String numero, final String complemento, final String bairro,
			final String cidade, final String estado, final String pais, final String cep
			) {
		
		this.codigo_aluno = codigo_aluno;
		this.aluno = aluno;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.observacao = observacao;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public int getCodigo_aluno() {
		return codigo_aluno;
	}

	public void setCodigo_aluno(int codigo_aluno) {
		this.codigo_aluno = codigo_aluno;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}