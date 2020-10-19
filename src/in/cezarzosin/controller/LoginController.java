package in.cezarzosin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cezarzosin.dao.LoginDAO;
import in.cezarzosin.dao.LoginDAOImplementation;
import in.cezarzosin.entity.Login;

public class LoginController extends HttpServlet {

	LoginDAO loginDAO = null;

	public LoginController() {
		loginDAO = new LoginDAOImplementation();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Login login = new Login();
		login.setEmail(req.getParameter("email"));
		login.setPassword(req.getParameter("password"));
		String status = loginDAO.authenticate(login);
		if (status.equals("true")) {
			resp.sendRedirect("EmployeeController?action=LIST");
		}
		if (status.equals("false")) {
			resp.sendRedirect("index.jsp?status=false");
		}
		if (status.equals("error")) {
			resp.sendRedirect("index.jsp?status=error");
		}

	}

}
