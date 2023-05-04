package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.Modalidade;

public class ModalidadeDAO extends AbstractDAO {
	
	private String select = "select * from modalidades where modalidade=?";
	private String selectAll = "select * from modalidades";
	private String insert = "INSERT INTO modalidades(modalidade, frequencia, valorMensal) VALUES (?, ?, ?)";
	private String delete = "delete from modalidades where modalidade = ?";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstDelete;
	
	public ModalidadeDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(select);
		pstSelectAll = conn.prepareStatement(selectAll);
		pstInsert = conn.prepareStatement(insert);
		pstDelete = conn.prepareStatement(delete);
	}

	@Override
	public List<Object> SelectAll() throws SQLException {		
		return Select(null);
	}

	@Override
	public List<Object> Select(Object param) throws SQLException {
		
		PreparedStatement pstLocal;
		Modalidade m;
		
		if (param != null) {
			m = (Modalidade) param;
			pstLocal = pstSelect;
			pstLocal.setString(1, m.getModalidade());
		}
		else {
			pstLocal = pstSelectAll;
		}
		
		List<Object> listaRetorno = new ArrayList<Object>();
		
		ResultSet resultado = pstLocal.executeQuery();
		while (resultado.next()) {
			m = new Modalidade();
			m.setModalidade(resultado.getString("usuario"));
			listaRetorno.add(m);
		}
		
		return listaRetorno;
	}

	@Override
	public void Insert(Object param) throws SQLException {		
		Modalidade m = (Modalidade) param;
		pstInsert.setString(1, m.getModalidade());
		pstInsert.setInt(2, m.getFrequencia());
		pstInsert.setDouble(3, m.getValorMensal());
		pstInsert.execute();
	}

	@Override
	public void Delete(Object param) throws SQLException {
		Modalidade m = (Modalidade) param;
		pstDelete.setString(1,  m.getModalidade());
		pstInsert.setInt(2, m.getFrequencia());
		pstInsert.setDouble(3, m.getValorMensal());
		pstDelete.execute();		
	}

	@Override
	public void Update(Object param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}