package in.cezarzosin.dao;

import java.util.List;

import in.cezarzosin.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> get();
	public boolean addEntry(Employee employee);
	public Employee getEntryByEdi(int id);
	public boolean updateAnEntry(Employee employee, int id);

}
