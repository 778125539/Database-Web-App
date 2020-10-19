package in.cezarzosin.dao;

import in.cezarzosin.entity.Login;

public interface LoginDAO {
	String authenticate(Login login);

}
