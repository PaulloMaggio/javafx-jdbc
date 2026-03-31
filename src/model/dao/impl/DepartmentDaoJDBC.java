package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();
			List<Department> list = new ArrayList<>();
			while (rs.next()) {
				Department obj = new Department();
				obj.setId(rs.getLong("Id"));
				obj.setName(rs.getString("Name"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

    // Adicione os outros metodos (insert, update, findById) seguindo o padrao Long
    @Override
	public Department findById(Long id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department obj = new Department();
				obj.setId(rs.getLong("Id"));
				obj.setName(rs.getString("Name"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
    
    @Override
	public void deleteById(Long id) {
        // Implementar deletar aqui usando st.setLong(1, id);
    }
    
    @Override
    public void insert(Department obj) {}
    
    @Override
    public void update(Department obj) {}
}