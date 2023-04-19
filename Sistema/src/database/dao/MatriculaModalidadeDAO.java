package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.MatriculaModalidade;
import database.model.MatriculaModalidade;

public class MatriculaModalidadeDAO extends AbstractDAO {
	
	private String selectWhere = "select * from matriculas_modalidades where codigo_matricula = ?";
	private String selectAll = "select * from matriculas_modalidades";
	private String insert = "INSERT INTO matriculas_modalidades(modalidade) VALUES (?)";
	private String update = "UPDATE matriculas_modalidades SET modalidade=?, graduacao=?, plano=?, data_inicio=?, data_fim=? WHERE codigo_matricula = ?";
	private String delete = "delete from matriculas_modalidades where modalidade = ?";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;
	
	public MatriculaModalidadeDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(selectWhere);
		pstSelectAll = conn.prepareStatement(selectAll);
		pstInsert = conn.prepareStatement(insert);
		pstUpdate = conn.prepareStatement(update);
		pstDelete = conn.prepareStatement(delete);
	}

	@Override
	public List<Object> SelectAll() throws SQLException {		
		return Select(null);
	}

	@Override
	public List<Object> Select(Object param) throws SQLException {
		
		PreparedStatement pstLocal;
		MatriculaModalidade m;
		
		if (param != null) {
			m = (MatriculaModalidade) param;
			pstLocal = pstSelect;
			pstLocal.setInt(1, m.getCodigoMatricula());
			pstLocal.setString(2, m.getModalidade());
			pstLocal.setString(3, m.getGraduacao());
			pstLocal.setString(4, m.getPlano());
			pstLocal.setDate(5, m.getDataInicio());
			pstLocal.setDate(6, m.getDataFim());
		}
		else {
			pstLocal = pstSelectAll;
		}
		
		List<Object> listaRetorno = new ArrayList<Object>();
		
		ResultSet resultado = pstLocal.executeQuery();
		while (resultado.next()) {
			m = new MatriculaModalidade();
			m.setCodigoMatricula(resultado.getInt("codigo_matricula"));
			m.setModalidade(resultado.getString("modalidade"));
			m.setGraduacao(resultado.getString("graduacao"));
			m.setPlano(resultado.getString("plano"));
			m.setDataInicio(resultado.getDate("data_inicio"));
			m.setDataFim(resultado.getDate("data_fim"));
			listaRetorno.add(m);
		}
		
		return listaRetorno;
	}

	@Override
	public void Insert(Object param) throws SQLException {		
		MatriculaModalidade m = (MatriculaModalidade) param;
		pstInsert.setString(1, m.getModalidade());
		pstInsert.setString(2, m.getGraduacao());
		pstInsert.setString(3, m.getPlano());
		pstInsert.setDate(4, m.getDataInicio());
		pstInsert.setDate(5, m.getDataFim());
		pstInsert.execute();
	}
	
	@Override
	public void Update(Object param) throws SQLException {
		MatriculaModalidade m = (MatriculaModalidade) param;
		pstUpdate.setString(1, m.getModalidade());
		pstUpdate.setString(2, m.getGraduacao());
		pstUpdate.setString(3, m.getPlano());
		pstUpdate.setDate(4, m.getDataInicio());
		pstUpdate.setDate(5, m.getDataFim());
		pstUpdate.execute();
	}

	@Override
	public void Delete(Object param) throws SQLException {
		MatriculaModalidade m = (MatriculaModalidade) param;
		pstDelete.setInt(1,  m.getCodigoMatricula());
		pstDelete.execute();		
	}

	
	
	
}