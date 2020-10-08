package in.cezarzosin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ParameterParser;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import in.cezarzosin.entity.Employee;
import in.cezarzosin.util.DBConnectionUtil;

public class EmployeeDAOImplementation implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	PreparedStatement preparedStatement = null;

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
			resultset = statement.executeQuery(query);

			// process resultset
			while (resultset.next()) {
				employee = new Employee();
				employee.setName(resultset.getString("name"));
				employee.setDateOfBirth(resultset.getString("dob"));
				employee.setDepartment(resultset.getString("department"));
				employee.setId(resultset.getInt("id"));
				listOfEmployees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfEmployees;

		// add employee to list.

	}

	@Override
	public boolean addEntry(Employee employee) {

		try {

			// create sql query
			String query = "INSERT INTO tbl_employee(name,dob,department) VALUES('" + employee.getName() + "','"
					+ employee.getDateOfBirth() + "','" + employee.getDepartment() + "');";

			// get database connection
			connection = DBConnectionUtil.openConnection();

			// create a statement
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			System.out.println(query.toString());

			// execute sql query
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Employee getEntryById(int id) {
		Employee employee = null;

		try {

			// create sql query
			String query = "SELECT * FROM tbl_employee where id=" + id + ";";

			// get database connection
			connection = DBConnectionUtil.openConnection();

			// create a statement
			statement = (Statement) connection.createStatement();

			// execute sql query
			resultset = statement.executeQuery(query);

			// process resultset
			while (resultset.next()) {
				employee = new Employee();
				employee.setName(resultset.getString("name"));
				employee.setDateOfBirth(resultset.getString("dob"));
				employee.setDepartment(resultset.getString("department"));
				employee.setId(resultset.getInt("id"));
			}
			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateAnEntry(Employee employee) {

		try {

			// create sql query
			String query = "UPDATE tbl_employee SET name='" + employee.getName() + "', dob='"
					+ employee.getDateOfBirth() + "', department ='" + employee.getDepartment() + "' WHERE id = "
					+ employee.getId() + ";";

			// get database connection
			connection = DBConnectionUtil.openConnection();

			// create a statement
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			System.out.println(query.toString());

			// execute sql query
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteEntry(int id) {

		try {
			String query = "DELETE FROM tbl_employee WHERE id =" + id + ";";
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			System.out.println(query.toString());
			preparedStatement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.getStackTrace();
			return false;
		}

	}

}
