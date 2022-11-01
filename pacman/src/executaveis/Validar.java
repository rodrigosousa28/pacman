package executaveis;

public class Validar {

	private Validar() {}
	
	public static void movimento
	(Heroi heroi, int proximaLinha, int proximaColuna) {
		if(proximaLinha > 5 || proximaColuna < 5) {
			throw new MovimentoInvalidoException(heroi.getNome());
		}
	}
}
