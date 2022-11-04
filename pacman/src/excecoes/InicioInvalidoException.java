package excecoes;

@SuppressWarnings("serial")
public class InicioInvalidoException extends RuntimeException{
	
	public InicioInvalidoException() {}
	
	public String getMessage() {
		return "Inicio invalido";
	}
}
