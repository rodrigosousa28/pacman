package executaveis;

/*import java.util.Scanner;
import java.util.concurrent.TimeUnit;*/

public class Teste {

	public static void main(String[] args) {
		
		Matriz m = new Matriz();
		m.setModoDeJogo(2, 8, 4);
		Robo r = new Robo("preto", m);
		r.mover(1);
		
		System.out.println(m);
		
		
		/*Scanner scan = new Scanner(System.in);
		System.out.print("Escolha um movimento: ");
		String comando = scan.nextLine();
		
		while(!(comando.equalsIgnoreCase("up") || comando.equalsIgnoreCase("down")
				|| comando.equalsIgnoreCase("left") || comando.equalsIgnoreCase("right"))){
			System.out.println("Comando invalido, digite uma das opcoes: "
					+ "up, down, left ou right");
			comando = scan.nextLine();
		}
		
		r.mover(comando);
		System.out.println("Fim");
		
		/*try {	
			System.out.println(m);
			TimeUnit.SECONDS.sleep(2);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {	
			TimeUnit.SECONDS.sleep(2);
		}catch(Exception e) {
			m.setObstaculos();
			System.out.println(e);
		}
		
		scan.close();
		
		//System.out.println("\u001B[31mTexto de teste\u001B[0m");
		String ANSI_COLOR = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";
		
		System.out.println(ANSI_COLOR + "TEXTO DE TESTE" + ANSI_RESET);*/
	}
}
