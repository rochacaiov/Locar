package ucb.locar.exceptions;


public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "USUÁRIO NÃO ENCONTRADO NO BANCO DE DADOS";
	}
	
}
