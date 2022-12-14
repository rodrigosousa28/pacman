package personagens;

import matriz.Matriz;

public class AntiHeroi extends Heroi{

	public AntiHeroi(String color, Matriz matriz) {
		super(color, matriz);
	}

	public AntiHeroi(Matriz matriz) {
		super(matriz);
		matriz.setAntiHeroi(this);
		this.x = 9;
		this.y = 1;
		
		final String ANSI_RESET = "\u001B[0m";
		String ANSI_COLOR = "\u001B[31m";
		
		switch(matriz.getModoDeJogo()) {
		case 5:
			emoji = "๐จโ๐พ ";
			super.nome = "Fazendeiro";
			break;
		case 6:
			emoji = "๐ค ";
			super.nome = "Robรด";
			break;
		case 7:
			emoji = "๐ฎ ";
			super.nome = "Policial";
			break;
		case 8:
			emoji = "๐ ";
			super.nome = "Rato";
			break;
		}
		String color = ANSI_COLOR + emoji + ANSI_RESET;
		this.heroi = color;
		
		matriz.setPosicao(y, x, this.heroi);
	}
}
