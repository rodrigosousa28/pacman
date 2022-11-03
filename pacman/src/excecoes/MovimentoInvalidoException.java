package excecoes;

@SuppressWarnings("serial")
public class MovimentoInvalidoException extends RuntimeException{
	String nomeVariavel;

	public MovimentoInvalidoException(String nomeVariavel) {
		this.nomeVariavel = nomeVariavel;
	}

	public String getMessage() {
		return String.format("O movimento do %s foi inválido!",
				nomeVariavel);
	}
}
