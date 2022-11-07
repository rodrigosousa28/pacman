package game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import excecoes.MovimentoInvalidoException;
import excecoes.VitoriaException;
import matriz.Matriz;
import personagens.AntiHeroi;
import personagens.Heroi;

//import excecoes.GameOverException;

public class Teste {

	public static void main(String[] args) {
		
		/*System.out.println("oi");
		Teste.esperar(1);
		System.out.println("carregando...");
		Teste.esperar(3);
		System.out.println("FIM!!!!");
		
		Matriz m = new Matriz();
		m.setModoDeJogo(2, 3);
		Heroi h = new Heroi("preto", m);
		System.out.println(m.getLinhaObjetivo());
		System.out.println(m.getColunaObjetivo());
		
		boolean condition = true;
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
			}catch(MovimentoInvalidoException mov) {
				System.out.println("INVALIDO");
				System.out.println(m);
			}
			Teste.esperar(500);
		}*/
		Scanner scan = new Scanner(System.in);
		Matriz m = new Matriz();
		m.setModoDeJogo(5);
		Heroi h = new Heroi("preto", m);
		Heroi a = new AntiHeroi(m);
		
		System.out.println(m.getColunaAntiHeroi());
		System.out.println(a.getX());
		System.out.println(m.getLinhaAntiHeroi());
		System.out.println(a.getY());
		
		System.out.println(h.getX());
		System.out.println(h.getY());
		System.out.println(m);
		while(true) {
			
	    	try {
	    		System.out.println(m);
	    		Teste.esperar(300);
	    		h.mover();
	    		System.out.println(m);
	    	}catch(VitoriaException v1) {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		break;
	    	}catch(MovimentoInvalidoException e1) {	    		
	    		Teste.esperar(300);
	    	}
	    	try {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		a.mover();
	    		System.out.println(m);
	    	}catch(VitoriaException v2) {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		break;
	    	}catch(MovimentoInvalidoException e1) {
	    		Teste.esperar(300);	    		
	    	}
	    	
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
