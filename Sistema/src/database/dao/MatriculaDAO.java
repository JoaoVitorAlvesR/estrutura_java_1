package database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.MatriculaModel;
import database.model.Modalidade;


public class MatriculaDAO extends AbstractDAO {
	
	private String select = "SELECT * FROM matriculas where codigo_aluno=?";
	private String selectAll = "SELECT * FROM matriculas";
	//private String insert = "INSERT INTO matriculas (codigo_aluno, data_matricula, dia_vencimento, data_encerramento) VALUES(?, ?, ?, ?)";
	private String insert = "INSERT INTO matriculas (codigo_aluno, dia_vencimento) VALUES(?, ?)";
	private String delete = "delete from matriculas where codigo_aluno = ?";
	private String update = "UPDATE matriculas SET data_matricula=?, data_encerramento=? WHERE codigo_matricula=nextval('matriculas_codigo_matricula_seq'::regclass)";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstDelete;
	private PreparedStatement pstUpdate;
	
	public MatriculaDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(select);
		pstSelectAll = conn.prepareStatement(selectAll);
		pstInsert = conn.prepareStatement(insert);
		pstDelete = conn.prepareStatement(delete);
		pstUpdate = conn.prepareStatement(update);
	}

	@Override
	public List<Object> SelectAll() throws SQLException {		
		return Select(null);
	}

	@Override
	public List<Object> Select(Object param) throws SQLException {
		
		PreparedStatement pstLocal;
		MatriculaModel m;
		
		if (param != null) {
			m = (MatriculaModel) param;
			pstLocal = pstSelect;
			pstLocal.setInt(1, m.getCodigo_aluno());
		}
		else {
			pstLocal = pstSelectAll;
		}
		
		List<Object> listaRetorno = new ArrayList<Object>();
		
		ResultSet resultado = pstLocal.executeQuery();
		while (resultado.next()) {
			m = new MatriculaModel();
			m.setMatricula(resultado.getInt("codigo_matricula"));
			listaRetorno.add(m);
		}
		
		return listaRetorno;
	}
	
	
	@Override
	public void Insert(Object param) throws SQLException {
		MatriculaModel m = (MatriculaModel) param;
		pstInsert.setInt(1, m.getCodigo_aluno());
		System.out.println(m.getCodigo_aluno());
//		pstInsert.setDate(2, (Date) m.getData_matricula());
		pstInsert.setInt(2, m.getDia_vencimento());
		//pstInsert.setDate(4, (Date) m.getDia_encerramento());
		
		pstInsert.execute();
		
	}

	@Override
	public void Update(Object param) throws SQLException {
		pstUpdate.clearParameters();
		MatriculaModel m =	(MatriculaModel) param ;
		
		
		Set(pstUpdate, 1, m.getData_matricula());
		Set(pstUpdate, 2,m.getDia_encerramento());
		
		pstUpdate.execute();
		
	}

	private void Set(PreparedStatement pstUpdate2, int i, java.util.Date data_matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object param) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
