package game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import excecoes.*;
import matriz.Matriz;
import personagens.Heroi;

public class Modo1 {
    public static void main(String[] args) {
    Scanner scan  = new Scanner(System.in);
   
    System.out.println("=============================== BEM-VINDO AO GAME! ==============================");
    System.out.println();
    System.out.println("                   Todos temos nossas própias história... me diga a sua.         ");
    System.out.println();
    System.out.println("=============================    ESCOLHA O HERÓI     ============================");
    Modo1.esperar(250);
    System.out.println("\nLoading...");
    Modo1.esperar(1500);
     
    System.out.println("          \nQuem é você? ME RESPONDA!!!!\n  ");
    System.out.println("Você é...  1 👨‍🌾 - FAZENDEIRO: Luto todo dia nesse milharal atrás");
    System.out.println("           do possivelmente o ultimo banquete, não quero que seja em vão... eu luto por elas  \n                         ");
    System.out.println("           2 🤖 - ROBO: Sou um homem de lata e apenas desejo                                        ");
    System.out.println("           recuperar meu coração e sentir sentimentos                                               ");
    System.out.println("           que sempre me esconderam desse muro vázio... \n                                          ");
    System.out.println("           3 👮 - POLICIAL: Em meio a esse caos a justiça deve sempre prevalecer                     ");
    System.out.println("           e não deixeirei impune aqueles que feriram inocentes. LUTO PELA JUSTIÇA NÃO SILENCIADA!\n");
    System.out.println("           4 🐀 - RATO: já esse é somente um animal buscando sobreviver.\n"                          );
    System.out.println("AVISO - Lembre-se que a opção é respectivamente a ordem dos personagens."                            );
    
    Modo1.esperar(1500);
    System.out.print("SELECIONE: ");
    int modo = scan.nextInt();
    
    while(!(modo == 1 || modo == 2 || modo == 3 || modo == 4)){
        Modo1.esperar(1000);
        System.out.print("%nVOCÊ SABE NEM DIZER O QUE É OU QUEM É?\n"
        		+ "FALE OU NÃO PASSARÁ: ");
        modo = scan.nextInt();
        System.out.println();
        Teste.esperar(1000);
    }
    System.out.println("Ok, vá para o menu de dificuldade agora.\n");
    Teste.esperar(1000);    
   
    
    System.out.println("===============================  MENU DE  DIFICULDADE  ============================ ");
    System.out.println();
    System.out.println("Você é covarde? S/N ");
    String resposta = scan.next();
	
	while(!resposta.equalsIgnoreCase("S")){
		if(resposta.equalsIgnoreCase("N"))
			System.out.println("Você pensa que me engana? Eu programo em JAVA");
		if(!(resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N")))
			System.out.println("Não entendo esse seu linguajar.");
		Modo1.esperar(500);
		System.out.print("Desembucha logo: ");
		resposta = scan.next();
	}
	
	Modo1.esperar(500);
	System.out.println("\nTá na cara não é? seu bastardo.");
	Modo1.esperar(500);

    System.out.println("\n\nNÃO ME IMPORTA!!");
    Modo1.esperar(500);
    System.out.println("\nLEVEL 1: Seja franco né, você ainda deve andar de fralda.\n");
    Modo1.esperar(3000);
    System.out.println("LEVEL 2: Tá... é até aceitavel, mas ainda é motivo para ser zoado na roda de amigos.\n");
    Modo1.esperar(3000);
    System.out.println("LEVEL 3: Você tem coragem, mas não é o suficiente para ganhar meu respeito.\n");
    Modo1.esperar(1500);
    
    System.out.print("ESCOLHA: ");
    int dificuldade = scan.nextInt();
    Modo1.esperar(500);
    
    while(!(dificuldade >= 1 && dificuldade <=3)) {
    	System.out.println("Você não consegue ler? Escolha uma opção válida: \n");
    	dificuldade = scan.nextInt();
    }
    
    Modo1.esperar(500);
    
    System.out.println("===============================   MENU DE CONSOLE   ===============================  ");
    System.out.println();
    System.out.println("AVISO: O sistema de movimentação já está fixo em duas opções                         ");
    System.out.println();
    Modo1.esperar(500);
    System.out.println("     TIPO 1:  -------                             TIPO 2:  -------                   ");
    System.out.println("             |       |    U = UP   D = DOWN               |       |                  ");   
    System.out.println("             |   U   |    L = LEFT R = RIGHT              |   1   |                  ");
    System.out.println("             |       |                                    |       |                  ");
    System.out.println("              -------                                      -------                   ");
    System.out.println("  -------     -------     -------              -------     -------     -------       ");
    System.out.println(" |       |   |       |   |       |            |       |   |       |   |       |      ");   
    System.out.println(" |   L   |   |   D   |   |   R   |            |   3   |   |   2   |   |   4   |      ");
    System.out.println(" |       |   |       |   |       |            |       |   |       |   |       |      ");
    System.out.println("  -------     -------     -------              -------     -------     -------       ");
    Modo1.esperar(2000);
    System.out.println("            AVISO DE BÔNUS - ESCOLHA A COR DO SEU PERSONAGEM\n                       ");
    Modo1.esperar(1000);
    System.out.println("          PRETO - VERMELHO - VERDE - AMARELO - AZUL - ROXO - CIANO                   ");
    Modo1.esperar(1000);
    System.out.print("\nESCOLHA: ");  
    String color = scan.next();
    System.out.println("\n");
    Modo1.esperar(1200);
    Matriz  m    = new Matriz();
    m.setModoDeJogo(modo, dificuldade);
    Heroi heroi = new Heroi(color, m);
    
    System.out.println("===============================        GAMER       ================================");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("                   Sua jornada começa aqui                                                                  ");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("                                 Lhe desejo sorte                                                           ");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("                                           Cuidado com o que você está atrás                                                      ");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("          Um descuido e você é só história                                                   ");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("                                            Então não bata de frente com o que você TEME.                              ");
    System.out.println();
    Modo1.esperar(1200);
    System.out.println("\n\nREGRAS: Corras dos obstaculos\n        Recupere o objetivo\n        Não saia do quadrante do objetivo\n        Ganhe ");
    System.out.println();
    Modo1.esperar(1200);
    
    boolean condition = true;
	Integer comand = 0;
	
	while(condition){
		System.out.println(m);
		Modo1.esperar(1200);
		System.out.print("Escolha seu movimento: ");
		String comando = scan.next();
		
		try {
			try {
				comand = Integer.parseInt(comando);
				heroi.mover(comand);
			}catch(Exception e) {
				heroi.mover(comando);
			}
		} catch (GameOverException e) {
			System.out.println(m);
			System.out.println(e.getMessage());
			break;
		}catch (MovimentoInvalidoException e) {}
		catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("NÃO VÁ! ZONA DE PERIGO");
		}catch (MovimentoInvalidoObstaculoException movimento){
			System.out.println(m);
		}
		catch(VitoriaException v) {
			System.out.println(m);
			System.out.println(v.getMessage());
			break;
		}
		Teste.esperar(500);
	}
    
    scan.close();
   }
    public static void esperar(int tempo){
    	try {
    		TimeUnit.MILLISECONDS.sleep(tempo);
    	} catch (InterruptedException e) {
    		
    	} 
    }
}
    