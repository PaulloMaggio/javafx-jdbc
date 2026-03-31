package model.dao;

import java.util.List;
import model.entities.Department;

public interface DepartmentDao {
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Long id);
	Department findById(Long id);
	List<Department> findAll();
}