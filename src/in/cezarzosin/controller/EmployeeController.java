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
	RequestDispatcher dispatcher = null;

	public EmployeeController() {
		employeeDAO = new EmployeeDAOImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "LIST":
			System.out.println("List");
			listEmployees(request, response);
			break;

		case "EDIT":
			System.out.println("Edit");
			editEmployees(request, response);
			break;

		case "UPDATE":
			System.out.println("Update");
			updateEmployee(request, response);
			break;
			


		default:
			System.out.println("Default");
			listEmployees(request, response);

			break;
		}

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
		listEmployees(request, response);

	}
	


	public void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listOfEmployees = employeeDAO.get();
		request.setAttribute("listOfEmployees", listOfEmployees);

		dispatcher = request.getRequestDispatcher("Views/employee-list.jsp");
		dispatcher.forward(request, response);

	}

	public void editEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String String_id = request.getParameter("id");
		int id = Integer.parseInt(String_id);
		Employee employee = employeeDAO.getEntryByEdi(id);
		String nameOfEmployee = employee.getName();
		String dateOfBirthOfEmployee = employee.getDateOfBirth();
		String departmentOfEmployee = employee.getDepartment();
		request.setAttribute("nameOfEmployee", nameOfEmployee);
		request.setAttribute("dateOfBirthOfEmployee", dateOfBirthOfEmployee);
		request.setAttribute("departmentOfEmployee", departmentOfEmployee);

		dispatcher = request.getRequestDispatcher("Views/AddEmployee.jsp");
		dispatcher.forward(request, response);

	}

	public void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String String_id = request.getParameter("id");
		int id = Integer.parseInt(String_id);
		String firstname = request.getParameter("firstname");
		String dateOfBirth = request.getParameter("dob");
		String department = request.getParameter("department");
		Employee employee = new Employee();
		employee.setName(firstname);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDepartment(department);
		employeeDAO.updateAnEntry(employee, id);
		request.setAttribute("message", "Employee no. " + id + " updated successfully");
		listEmployees(request, response);

	}

}
