package executaveis;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import excecoes.GameOverException;

//import excecoes.GameOverException;

public class Teste {

	public static void main(String[] args) {
		
		/*System.out.println("oi");
		Teste.esperar(1);
		System.out.println("carregando...");
		Teste.esperar(3);
		System.out.println("FIM!!!!");*/
		
		Matriz m = new Matriz();
		m.setModoDeJogo(2, 3);
		Heroi h = new Heroi("preto", m);
		System.out.println(m.getColunaObjetivo());
		System.out.println(m.getLinhaObjetivo());
		
		boolean condition = true;
		Scanner scan = new Scanner(System.in);
		Integer comand = 0;
		while(condition){
			System.out.println(m);
			System.out.print("Comando: ");
			String comando = scan.nextLine();
			try {
				try {
					comand = Integer.parseInt(comando);
					h.mover(comand);
				}catch(Exception e) {
					h.mover(comando);
				}
			} catch (GameOverException e) {
				System.out.println(m);
				System.out.println(e.getMessage());
				break;
			}
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
