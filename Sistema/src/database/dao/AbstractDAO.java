package database.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO {

	public abstract List<Object> SelectAll() throws SQLException;
	public abstract List<Object> Select(Object param) throws SQLException;
	
	public abstract void Insert(Object param) throws SQLException;
	public abstract void Update(Object param) throws SQLException;
	public abstract void Delete(Object param) throws SQLException;
	
}
