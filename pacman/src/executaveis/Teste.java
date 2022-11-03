package executaveis;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import excecoes.GameOverException;

public class Teste {

	public static void main(String[] args) {
		
		/*System.out.println("oi");
		Teste.esperar(1);
		System.out.println("carregando...");
		Teste.esperar(3);
		System.out.println("FIM!!!!");*/
		
		Matriz m = new Matriz();
		m.setModoDeJogo(4, 3);
		HeroiInteligente h = new HeroiInteligente("preto", m);
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(m);
			Teste.esperar(1);
			System.out.print("Comando: ");
			String comando = scan.nextLine();
			try {
				h.mover(comando);				
			}catch(GameOverException g) {
				System.out.println(m);
				System.out.println(g.getMessage());
				break;
			}
			Teste.esperar(1);
		}
	}
	
	public static void esperar(int tempo) {
		try {
			TimeUnit.SECONDS.sleep(tempo);
		}catch (InterruptedException e) {
			
		}
	}
	
}
