package excecoes;

public class VitoriaException extends RuntimeException{

	public VitoriaException() {
		
	}
	
	public String getMessage() {
		return "\n                   PARABÉNS                 \n"
				+ "VOCÊ DEMONSTROU CORAGEM E CHEGOU AO OBJETIVO!";
	}
}
