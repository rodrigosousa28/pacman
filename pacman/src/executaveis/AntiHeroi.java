package executaveis;

public class AntiHeroi extends Heroi{

	public AntiHeroi(String color, Matriz matriz) {
		super(color, matriz);
	}

	public AntiHeroi(Matriz matriz) {
		super(matriz);
		matriz.setHeroi(this);
		this.x = 9;
		this.y = 1;
		
		final String ANSI_RESET = "\u001B[0m";
		String ANSI_COLOR = "\u001B[31m";
		
		switch(matriz.getModoDeJogo()) {
		case 5:
			emoji = "👨‍🌾 ";
			super.nome = "Fazendeiro";
			break;
		case 6:
			emoji = "🤖 ";
			super.nome = "Robô";
			break;
		case 7:
			emoji = "👮 ";
			super.nome = "Policial";
			break;
		case 8:
			emoji = "🐀 ";
			super.nome = "Rato";
			break;
		}
		String color = ANSI_COLOR + emoji + ANSI_RESET;
		this.heroi = color;
		
		matriz.setPosicao(y, x, this.heroi);
	}
}
