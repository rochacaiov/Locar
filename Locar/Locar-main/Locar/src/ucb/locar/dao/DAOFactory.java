package ucb.locar.dao;

public class DAOFactory {

	public static UserDAO createUserDAO() {
		return new UserDAO();
	}
	
}
