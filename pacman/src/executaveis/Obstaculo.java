package executaveis;

import java.util.Random;

public class Obstaculo extends Personagem{
	
	private String OBSTACULO;

	public Obstaculo(Matriz matriz) {
		super(matriz);
		Random random = new Random();
		int linhaObstaculo = random.nextInt(1, 6);
		int colunaObstaculo = random.nextInt(5, 11);
		
		final String ANSI_COLOR;
		final String ANSI_RESET = "\u001B[0m";
		
		switch(matriz.getModoDeJogo()) {
		case 1:
			ANSI_COLOR = "\u001B[36m";
			OBSTACULO = ANSI_COLOR + "🐺 " + ANSI_RESET;
			break;
		case 2:
			OBSTACULO = "🧙‍♀️‍ ";
			break;
		case 3:
			ANSI_COLOR = "\u001B[32m";
			OBSTACULO = ANSI_COLOR + "🧟 " + ANSI_RESET;
			break;
		case 4:
			OBSTACULO = "🐈 ";
			break;
		}
		
		matriz.setPosicao(linhaObstaculo, colunaObstaculo, OBSTACULO);
	}

	public void mover(String comando) {
		
	}

	public void mover(int comando) {
		
	}
	
	
}
