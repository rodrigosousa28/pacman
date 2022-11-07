package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import excecoes.MovimentoInvalidoException;
import excecoes.VitoriaException;
import matriz.Matriz;
import personagens.AntiHeroi;
import personagens.Heroi;
import personagens.HeroiInteligente;

public class Modo2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("=============================================================== MODO TELESPECTADOR ================================================================ ");
		System.out.println("                                                                                                                                                     ");
		System.out.println("                                           ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━                                               ");
		System.out.println("                                          │  AVISO: ESSE MODO É SOMENTE PARA ADMIRAÇÃO E APRENDIZADO  │                                              ");
	    System.out.println("                                           ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ \n                                            ");
		
	    System.out.println("\nLoading...");
	    Teste.esperar(1500);
		
	    System.out.println(" ================================================================ BEM-VINDO AO GAME! =============================================================== ");
	    System.out.println();
	    System.out.println(" ==================================================   Todos temos nossas própias histórias...  ===================================================== ");
	    System.out.println();
	    Teste.esperar(1500);
	    System.out.println(" =============================================   Porém, nesse modo você contemplará a melhor forma     ============================================= ");
	    System.out.println();
	    Teste.esperar(1500);
	    System.out.println(" ======================================================   de se vivenciar cada uma delas   ========================================================= ");
	    System.out.println();
	    Teste.esperar(1500);
	    
	    System.out.println(" ============================================================    ESCOLHA O HERÓI!!!   ============================================================== ");
	    System.out.println();
	    Teste.esperar(1000);
	    
		System.out.println("  1 👨‍🌾 - FAZENDEIRO: Luto todo dia nesse milharal atrás                                                                ");
	    System.out.println("         do possivelmente o ultimo banquete, e sou extremamente bom no que faço!!!  \n                                 ");
	    System.out.println("  2 🤖 - ROBO: Sou um homem de lata e apenas desejo                                                                     ");
	    System.out.println("         recuperar meu coração e sentir sentimentos                                                                     ");
	    System.out.println("         que sempre me esconderam desse muro vázio... \n                                                                ");
	    System.out.println("  3 👮 - POLICIAL: Em meio a esse caos a justiça deve sempre prevalecer                                                  ");
	    System.out.println("         e não deixeirei impune aqueles que feriram inocentes. LUTO PELA JUSTIÇA NÃO SILENCIADA!\n                       ");
	    System.out.println("  4 🐀 - RATO: Sou apenas um animal buscando minha sobrevivencia diária.                                                  ");
	    System.out.println();
	    System.out.print("ESCOLHA O PERSONAGEM DE ACORDO COM A ORDEM: ");
	    
	    int modo = scan.nextInt();
	    modo += 4; //Os modos nessa versão são de 5 a 8, então soma-se 4 à escolha do usuário
	    boolean condicaoModo = modo == 5 || modo == 6 || modo == 7 || modo == 8;
	    
	    Matriz m = new Matriz();
	  
	    if(condicaoModo) {
	        Teste.esperar(1000);
	    	m.setModoDeJogo(modo);
	    }else {
	        Teste.esperar(1000);
	    	System.out.println("Já que você escolheu errado... Seu Herói é um rato.\n");
	    	m.setModoDeJogo(8);
	    }
    	
    	System.out.println("Com o personagem escolhido,\nagora escolha uma cor para ele:");
    	System.out.println();
	    System.out.println("              PRETO - VERDE - AMARELO - AZUL - ROXO - CIANO                     ");
	    System.out.println();
	    System.out.print("ESCOLHA: ");
	    String color = scan.next();
    
	    final List<String> CORES = Arrays.asList("VERDE", "AMARELO", "AZUL", "ROXO", "CIANO", "PRETO");
	    
	    while (!CORES.contains(color.toUpperCase())) {
	    	System.out.print("Você não sabe nem escolher uma cor?");
	    	System.out.println();
	    	Teste.esperar(1000);
	    	System.out.print("ESCOLHA NOVAMENTE: ");
	    	color = scan.next(); 
	    }
	    	    
	    System.out.println("Cor escolhida com sucesso!!!");
	    Teste.esperar(1500);
	    
	    System.out.println("=============================================================== SELEÇÃO DE JOGO ================================================================");
		System.out.println();
		Teste.esperar(2000);
		System.out.println("                                                   BEM - VINDO AO MODO BOLÃO DE JOGOS!!!!!\n\n                                                                                         ");
		Teste.esperar(2000);
	    System.out.println("                         AGORA VOCÊ É SÓ UM ADMIRADOR DE NOSSO PROJETO E INFELIZMENTE FICARÁ QUETIN NA SUA CADEIRA\n ");
	    Teste.esperar(2000);
	    System.out.println("			         ENTÃO PREPARE-SE PARA UM BOLÃO DE APOSTA E ESCOLHA QUE GANHARÁ ESSA DISPUTA\n                                                                       ");
	    Teste.esperar(2000);
	    System.out.println("                                      VOCÊ JÁ SABE COMO FUNCIONA O JOGO ENTÃO NÃO ME IMPORTA EXPLICAR\n                                              ");
	    Teste.esperar(2000);
	    System.out.println("                                                    AQUI VOCÊ VERÁ UM HERÓI E UM VILÃO\n                                                                                                                ");
	    Teste.esperar(2000);
	    System.out.println("		                            ENTÃO VÁ PELO SEU CARATER E ESCOLHA QUEM SERÁ O VENCEDOR                                         ᴱˢᶜᵒˡʰᵃ ˢ ᵖᵃʳᵃ ᵒ ᵐᵒᵈᵒ ᵗʳᵃᵖᵃᶜ̧ᵃ....                                        ");
	    
	    Teste.esperar(2000);
	    System.out.println("\n1. Para apostar no Herói");
	    System.out.println("2. Para apostar no Vilão");
	    System.out.print("ESCOLHA:");
	    int choice = scan.nextInt();
	    while(!(choice==1 || choice == 2)) {
	    	System.out.println();
	    	System.out.print("Escolha 1 ou 2: ");
	    	choice = scan.nextInt();
	    }

	    Teste.esperar(100);
	    System.out.println("\nPRESSIONE QUALQUER TECLA PARA INICIAR: ");
	    String inicio = scan.next();
	    
	    Heroi antiHeroi = new AntiHeroi(m);	
	    Heroi heroi;
	    
	    if(inicio.equalsIgnoreCase("s") && choice == 1) {
	    	heroi = new HeroiInteligente(color, m);
	    }else {
	    	heroi = new Heroi(color, m);
	    }
	    
	    Teste.esperar(1500);

	    while(true) {
	    	try {
	    		System.out.println(m);
	    		Teste.esperar(300);
	    		heroi.mover();
	    		System.out.println(m);
	    	}catch(VitoriaException v1) {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		if(choice == 1) {
	    			System.out.println("\nPARABÉNS, VOCÊ VENCEU!!!");
	    		}else if(choice == 2){
	    			System.out.println("QUE PENA, VOCÊ PERDEU!!!");
	    		}
	    		break;
	    	}catch(MovimentoInvalidoException e1) {}
	    	try {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		antiHeroi.mover();
	    		System.out.println(m);
	    	}catch(VitoriaException v2) {
	    		Teste.esperar(300);
	    		System.out.println(m);
	    		if(choice == 2) {
	    			System.out.println("\nPARABÉNS, VOCÊ VENCEU!!!");
	    		}else if(choice == 1){
	    			System.out.println("QUE PENA, VOCÊ PERDEU!!!");
	    		}
	    		break;
	    	}catch(MovimentoInvalidoException e1) {}
		}
	    
	    scan.close();
   }
   
}
