package ucb.locar.exceptions;


public class InvalidLoginException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "USUÁRIO OU SENHA INVÁLIDO";
	}
	
}
