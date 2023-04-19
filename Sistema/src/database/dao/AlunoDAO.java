package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import database.model.Aluno;

public class AlunoDAO extends AbstractDAO {
	
	private String selectCommand = "select * from public.alunos";
	private String selectWhereCommand = "select * from public.alunos where aluno = '?'";

	private String insertCommand = 
			"INSERT INTO alunos(aluno, sexo, telefone, cpf, celular, email, observacao, endereco, numero, complemento, bairro, cidade, estado, pais, cep, data_nascimento) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectWhere;
	private PreparedStatement pstInsert;
	
	public AlunoDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(selectCommand);
		pstSelectWhere = conn.prepareStatement(selectWhereCommand);
		pstInsert = conn.prepareStatement(insertCommand);
	}
	
	
	@Override
	public List<Object> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> Select(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(Object param) throws SQLException {
		Aluno a = (Aluno)param;
		pstInsert.setString(1, a.getAluno());
		pstInsert.setString(2, a.getSexo());
		pstInsert.setString(3, a.getTelefone());
		pstInsert.setString(4, a.getCpf());
		pstInsert.setString(5, a.getCelular());
		pstInsert.setString(6, a.getEmail());
		pstInsert.setString(7, a.getObservacao());
		pstInsert.setString(8, a.getEndereco());
		pstInsert.setString(9, a.getNumero());
		pstInsert.setString(10, a.getComplemento());
		pstInsert.setString(11, a.getBairro());
		pstInsert.setString(12, a.getCidade());
		pstInsert.setString(13, a.getEstado());
		pstInsert.setString(14, a.getPais());
		pstInsert.setString(15, a.getCep());
		pstInsert.setString(16, a.getData_nascimento());
		pstInsert.execute();
		
	}

	@Override
	public void Update(Object param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object param) {
		// TODO Auto-generated method stub
		
	}

}