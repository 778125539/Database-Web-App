package in.cezarzosin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cezarzosin.dao.EmployeeDAO;
import in.cezarzosin.dao.EmployeeDAOImplementation;
import in.cezarzosin.entity.Employee;

public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	EmployeeDAOImplementation employeeDAO = null;

	public EmployeeController() {
		employeeDAO = new EmployeeDAOImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listOfEmployees = employeeDAO.get();
		request.setAttribute("listOfEmployees", listOfEmployees);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/employee-list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String dateOfBirth = request.getParameter("dob");
		String department = request.getParameter("department");
		Employee employee = new Employee();
		employee.setName(firstname);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDepartment(department);
		if (employeeDAO.addEntry(employee)) {
			request.setAttribute("message", "Saved successfully");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/AddEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
