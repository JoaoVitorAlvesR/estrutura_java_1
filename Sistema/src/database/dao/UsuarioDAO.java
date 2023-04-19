package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.Usuario;

public class UsuarioDAO extends AbstractDAO {
	
	private String select = "select * from tb_usuarios where usuario = ? and senha = ?";
	private String selectAll = "select * from tb_usuarios";
	private String insert = "INSERT INTO tb_usuarios(usuario, senha, perfil) VALUES (?, ?, ?)";
	private String update = "UPDATE tb_usuarios SET senha=?, perfil=? WHERE id = ?";
	private String delete = "delete from tb_usuarios where id = ?";
	
	private PreparedStatement pstSelect;
	private PreparedStatement pstSelectAll;
	private PreparedStatement pstInsert;
	private PreparedStatement pstUpdate;
	private PreparedStatement pstDelete;
	
	public UsuarioDAO(Connection conn) throws SQLException {
		pstSelect = conn.prepareStatement(select);
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
		Usuario u;
		
		if (param != null) {
			u = (Usuario) param;
			pstLocal = pstSelect;
			pstLocal.setString(1, u.getUsuario());
			pstLocal.setString(2, u.getSenha());
		}
		else {
			pstLocal = pstSelectAll;
		}
		
		List<Object> listaRetorno = new ArrayList<Object>();
		
		ResultSet resultado = pstLocal.executeQuery();
		while (resultado.next()) {
			u = new Usuario();
			u.setId(resultado.getInt("id"));
			u.setUsuario(resultado.getString("usuario"));
			u.setSenha(resultado.getString("senha"));
			u.setPerfil(resultado.getString("perfil"));
			listaRetorno.add(u);
		}
		
		return listaRetorno;
	}

	@Override
	public void Insert(Object param) throws SQLException {		
		Usuario u = (Usuario) param;
		pstInsert.setString(1, u.getUsuario());
		pstInsert.setString(2, u.getSenha());
		pstInsert.setString(3, u.getPerfil());
		pstInsert.execute();
	}

	@Override
	public void Update(Object param) throws SQLException {
		Usuario u = (Usuario) param;
		pstUpdate.setString(1,  u.getSenha());
		pstUpdate.setString(2, u.getPerfil());
		pstUpdate.setInt(3, u.getId());
		pstUpdate.execute();
	}

	@Override
	public void Delete(Object param) throws SQLException {
		Usuario u = (Usuario) param;
		pstDelete.setInt(1,  u.getId());
		pstDelete.execute();		
	}

	
	
	
}







