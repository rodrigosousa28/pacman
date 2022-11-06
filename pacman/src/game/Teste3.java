package game;

import excecoes.MovimentoInvalidoException;
import excecoes.VitoriaException;
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
		
		while(true) {
			try {
				System.out.println(m);
				h.mover();
				Teste.esperar(1000);
				System.out.println(m);
				j.mover();
				Teste.esperar(1000);
			}catch(VitoriaException v) {
				System.out.println(m);
				System.out.println(v.getMessage());
				break;
			}catch(MovimentoInvalidoException mov) {
				System.out.println(mov.getMessage());
			}
		}
	}
}
