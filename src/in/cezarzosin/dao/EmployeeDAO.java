package in.cezarzosin.dao;

import java.util.List;

import in.cezarzosin.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> get();
	public boolean addEntry(Employee employee);
	public Employee getEntryById(int id);
	public boolean updateAnEntry(Employee employee);
	public boolean deleteEntry (int id);

}
