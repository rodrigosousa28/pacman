package executaveis;

import excecoes.GameOverException;
import excecoes.MovimentoInvalidoException;

public class Teste3 {

	public static void main(String[] args) {
		Matriz m = new Matriz();
		m.setModoDeJogo(5);
		//Corrigir o mover inteligente para não desviar do objetivo
		Heroi h = new HeroiInteligente("preto", m);
		Heroi j = new AntiHeroi(m);
		
	}
}
