package executaveis;

public class Robo extends Personagem{
	private final String HEROI;

	public Robo(String color, Matriz matriz) {
		super(matriz);	
		this.x = 5;
		this.y = 5;
		
		final String ANSI_RESET = "\u001B[0m";
		String ANSI_COLOR = "";
		String emoji = "";
		
		if(color.equalsIgnoreCase("vermelho")) {
			ANSI_COLOR = "\u001B[31m";
		}else if(color.equalsIgnoreCase("verde")) {
			ANSI_COLOR = "\u001B[32m";
		}else if(color.equalsIgnoreCase("amarelo")) {
			ANSI_COLOR = "\u001B[33m";
		}else if(color.equalsIgnoreCase("azul")) {
			ANSI_COLOR = "\u001B[34m";
		}else if(color.equalsIgnoreCase("roxo")) {
			ANSI_COLOR = "\u001B[35m";
		}else if(color.equalsIgnoreCase("ciano")) {
			ANSI_COLOR = "\u001B[36m";
		}
		
		switch(matriz.getModoDeJogo()) {
		case 1:
			emoji = "👨‍🌾 ";
			break;
		case 2:
			emoji = "🤖 ";
			break;
		case 3:
			emoji = "👮 ";
			break;
		case 4:
			emoji = "🐀 ";
			break;
		}
		color = ANSI_COLOR + emoji + ANSI_RESET;
		this.HEROI = color;
		matriz.setPosicao(x, y, this.HEROI);
	}

	public String getHeroi() {
		return HEROI;
	}
	
	public void mover(String comando) {
		int linhaRobo = getY();
		int colunaRobo = getX();
		
		if(linhaRobo != 5 && colunaRobo != 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "   ");			
		}else if(linhaRobo == 5 && colunaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "+ ");						
		}else if(linhaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "—— ");						
		}else if(colunaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "|  ");									
		}
		
		if(comando.equalsIgnoreCase("up")) {
			setY(getY() - 1);
		}else if(comando.equalsIgnoreCase("down")) {
			setY(getY() + 1);
		}else if(comando.equalsIgnoreCase("right")) {
			setX(this.getX() + 1);
		}else if(comando.equalsIgnoreCase("left")) {
			setX(this.getX() - 1);
		}
		linhaRobo = getY();
		colunaRobo = getX();
		
		matriz.setPosicao(linhaRobo, colunaRobo, getHeroi());
		
	}
	
	public void mover(int comando) {
		int linhaRobo = getY();
		int colunaRobo = getX();
		
		if(linhaRobo != 5 && colunaRobo != 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "   ");			
		}else if(linhaRobo == 5 && colunaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "+ ");						
		}else if(linhaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "—— ");						
		}else if(colunaRobo == 5) {
			matriz.setPosicao(linhaRobo, colunaRobo, "|  ");									
		}
		
		if(comando == 1) {
			setY(getY() - 1);
		}else if(comando == 2) {
			setY(getY() + 1);
		}else if(comando == 3) {
			setX(this.getX() + 1);
		}else if(comando == 4) {
			setX(this.getX() - 1);
		}
		linhaRobo = getY();
		colunaRobo = getX();
		
		matriz.setPosicao(linhaRobo, colunaRobo, getHeroi());
		
	}

}