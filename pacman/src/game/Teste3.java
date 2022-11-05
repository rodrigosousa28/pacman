package game;

import excecoes.GameOverException;
import excecoes.MovimentoInvalidoException;
import matriz.Matriz;
import personagens.AntiHeroi;
import personagens.Heroi;
import personagens.HeroiInteligente;

public class Teste3 {

	public static void main(String[] args) {
		Matriz m = new Matriz();
		m.setModoDeJogo(5);
		//Corrigir o mover inteligente para não desviar do objetivo
		Heroi h = new HeroiInteligente("preto", m);
		Heroi j = new AntiHeroi(m);
		
	}
}
