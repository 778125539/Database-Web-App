package in.cezarzosin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import in.cezarzosin.entity.Employee;
import in.cezarzosin.util.DBConnectionUtil;

public class EmployeeDAOImplementation implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;

	@Override
	public List<Employee> get() {
		// create reference variable
		List<Employee> listOfEmployees = null;
		Employee employee = null;

		try {
			listOfEmployees = new ArrayList<Employee>();
			// create sql query
			String query = "SELECT * FROM tbl_employee";

			// get database connection
			connection = DBConnectionUtil.openConnection();

			// create a statement
			statement = (Statement) connection.createStatement();

			// execute sql query
			statement.execute(query);

			// process resultset
			while (resultset.next()) {
				employee.setName(resultset.getString("name"));
				employee.setAge(resultset.getInt("id"));
				employee.setDateOfBirth(resultset.getString("dob"));
				employee.setDepartment(resultset.getString("department"));
				listOfEmployees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfEmployees;

		// add employee to list.

	}

}
