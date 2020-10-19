package in.cezarzosin.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import in.cezarzosin.entity.Login;
import in.cezarzosin.util.DBConnectionUtil;
import sun.management.counter.perf.PerfInstrumentation;

public class LoginDAOImplementation implements LoginDAO{

	@Override
	public String authenticate(Login login) {
		String query = "select * from tbl_login where email = ? and password =?";
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return "true";
			}
			else {
				return "false";
			}
				
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
	
	

}
