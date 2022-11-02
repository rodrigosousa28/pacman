package executaveis;

import java.util.concurrent.TimeUnit;

public class Teste {

	public static void main(String[] args) {
		
		/*System.out.println("oi");
		Teste.esperar(3);
		System.out.println("FIM!!!!");
		Teste.esperar(2);
		System.out.println("Fim parte 2");*/
		
		Matriz m = new Matriz();
		m.setModoDeJogo(4, 1);
		HeroiInteligente h = new HeroiInteligente("preto", m);
		
		for(int i = 0; i < 8; i++) {
			System.out.println(m);
			Teste.esperar(1);
			h.mover("up");
		}
	}
	
	public static void esperar(int tempo) {
		try {
			TimeUnit.SECONDS.sleep(tempo);
		}catch (InterruptedException e) {
			
		}
	}
	
}
