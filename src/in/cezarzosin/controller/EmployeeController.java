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
import sun.nio.cs.ext.ISCII91;

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
			listEmployees(request, response);
			break;

		case "EDIT":
			editEmployees(request, response);
			break;

		case "DELETE":
			deleteEmployee(request, response);
			break;

		case "WELCOME":
			welcome(request, response);
			break;

		default:
			listEmployees(request, response);

			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Employee employee = new Employee();
		String firstname = request.getParameter("firstname");
		String dateOfBirth = request.getParameter("dob");
		String department = request.getParameter("department");

		String password = request.getParameter("password");
		System.out.println("Info " + (password!=null) );

		
		if ( (password!=null) && password.equals("password")) {

			System.out.println("Password Accepted - > " + password);
			listEmployees(request, response);
			return;

		} 
			
		
		employee.setName(firstname);
		employee.setDateOfBirth(dateOfBirth);
		employee.setDepartment(department);

		if (id.isEmpty() || id == null) {
			if (employeeDAO.addEntry(employee))
				request.setAttribute("message", "Saved successfully");
		}

		else

		{
			employee.setId(Integer.parseInt(id));
			if (employeeDAO.updateAnEntry(employee))
				request.setAttribute("message", "Update successfully");
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
		Employee employee = employeeDAO.getEntryById(id);

		request.setAttribute("employee", employee);
		dispatcher = request.getRequestDispatcher("Views/AddEmployee.jsp");
		dispatcher.forward(request, response);

	}

	public void welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		dispatcher = request.getRequestDispatcher("Views/welcome.jsp");
		dispatcher.forward(request, response);

	}

	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String String_id = request.getParameter("id");
		int id = Integer.parseInt(String_id);
		if (employeeDAO.deleteEntry(id)) {
			request.setAttribute("message", "Delete successfully");
		}
		listEmployees(request, response);
	}

}
