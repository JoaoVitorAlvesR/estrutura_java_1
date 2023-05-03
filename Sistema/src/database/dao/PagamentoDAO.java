package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.Pagamento;

public class PagamentoDAO extends AbstractDAO {
	
	private String selectWhere = "select * from fatura_matricula where ?";
	private String selectAll = "select * from fatura_matricula";
	private String insert = "INSERT INTO fatura_matricula(codigo_matricula, data_vencimento, valor, data_pagamento, data_cancelamento) VALUES (?,?,?,?,?)";
	private String update = "UPDATE fatura_matricula SET modalidade=?, graduacao=?, plano=?, data_inicio=?, data_fim=? WHERE codigo_matricula = ?";
	private String updateStatus = "UPDATE fatura_matricula SET status=? WHERE codigo_matricula = ? and data_vencimento = ?";
	private String delete = "delete from fatura_matricula where codigo_matricula = ? and data_vencimento = ?";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstUpdateStatus;
	private PreparedStatement pstDelete;
	
	public PagamentoDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(selectWhere);
		pstSelectAll = conn.prepareStatement(selectAll);
		pstInsert = conn.prepareStatement(insert);
		pstUpdate = conn.prepareStatement(update);
		pstUpdateStatus = conn.prepareStatement(updateStatus);
		pstDelete = conn.prepareStatement(delete);
	}

	@Override
	public List<Object> SelectAll() throws SQLException {		
		return Select(null);
	}

	@Override
	public List<Object> Select(Object param) throws SQLException {
		
		PreparedStatement pstLocal;
		Pagamento pagamento = new Pagamento();
		
		if (param != null) {
			pstLocal = pstSelect;
			pstLocal.setInt(1, pagamento.getCodigoMatricula());
			pstLocal.setTimestamp(2, pagamento.getDataVencimento());
			pstLocal.setDouble(3, pagamento.getValor());
			pstLocal.setTimestamp(4, pagamento.getDataPagamento());
			pstLocal.setTimestamp(5, pagamento.getDataCancelamento());
		}
		else {
			pstLocal = pstSelectAll;
		}
		
		List<Object> listaRetorno = new ArrayList<Object>();
		
		ResultSet resultado = pstLocal.executeQuery();
		while (resultado.next()) {
			pagamento = new Pagamento();
			pagamento.setCodigoMatricula(resultado.getInt("codigo_matricula"));
			pagamento.setDataVencimento(resultado.getTimestamp("data_vencimento"));
			pagamento.setValor(resultado.getDouble("valor"));
			pagamento.setDataPagamento(resultado.getTimestamp("data_pagamento"));
			pagamento.setDataCancelamento(resultado.getTimestamp("data_cancelamento"));
			listaRetorno.add(pagamento);
		}
		
		return listaRetorno;
	}

	@Override
	public void Insert(Object param) throws SQLException {		
		Pagamento pagamento = (Pagamento) param;
		pstInsert.setInt(1, pagamento.getCodigoMatricula());
		pstInsert.setTimestamp(2, pagamento.getDataVencimento());
		pstInsert.setDouble(3, pagamento.getValor());
		pstInsert.setTimestamp(4, pagamento.getDataPagamento());
		pstInsert.setTimestamp(5, pagamento.getDataCancelamento());
		pstInsert.execute();
	}
	
	@Override
	public void Update(Object param) throws SQLException {
		Pagamento pagamento = (Pagamento) param;
		pstUpdate.setInt(1, pagamento.getCodigoMatricula());
		pstUpdate.setTimestamp(2, pagamento.getDataVencimento());
		pstUpdate.setDouble(3, pagamento.getValor());
		pstUpdate.setTimestamp(4, pagamento.getDataPagamento());
		pstUpdate.setTimestamp(5, pagamento.getDataCancelamento());
		pstUpdate.execute();
	}
	
	public void UpdateStatus(Object param) throws SQLException {
		Pagamento pagamento = (Pagamento) param;
		pstUpdateStatus.setString(1, pagamento.getStatus().toString());
		pstUpdateStatus.setInt(2, pagamento.getCodigoMatricula());
		pstUpdateStatus.setTimestamp(3, pagamento.getDataVencimento());
		pstUpdateStatus.execute();
	}

	@Override
	public void Delete(Object param) throws SQLException {
		Pagamento pagamento = (Pagamento) param;
		pstDelete.setInt(1,  pagamento.getCodigoMatricula());
		pstDelete.setTimestamp(2, pagamento.getDataVencimento());
		pstDelete.execute();		
	}

	
	
	
}