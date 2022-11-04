package executaveis;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import excecoes.GameOverException;

public class Teste {

	public static void main(String[] args) {
		
		/*System.out.println("oi");
		Teste.esperar(1);
		System.out.println("carregando...");
		Teste.esperar(3);
		System.out.println("FIM!!!!");*/
		
		Matriz m = new Matriz();
		m.setModoDeJogo(4, 2);
		Heroi h = new HeroiInteligente("preto", m);
		
		boolean condition = true;
		Scanner scan = new Scanner(System.in);
		while(condition){
			System.out.println(m);
			System.out.print("Comando: ");
			String comando = scan.nextLine();
			h.mover(comando);
			Teste.esperar(500);
		}
		scan.close();
	}
	
	public static void esperar(int tempo) {
		try {
			TimeUnit.MILLISECONDS.sleep(tempo);
		}catch (InterruptedException e) {
			
		}
	}
	
}
