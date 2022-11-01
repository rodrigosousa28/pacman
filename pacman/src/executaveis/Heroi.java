package executaveis;

import excecoes.*;

public class Heroi extends Personagem{
	private final String HEROI;

	public Heroi(String color, Matriz matriz) {
		super(matriz);
		matriz.setRobo(this);
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
			super.nome = "Fazendeiro";
			break;
		case 2:
			emoji = "🤖 ";
			super.nome = "Robô";
			break;
		case 3:
			emoji = "👮 ";
			super.nome = "Policial";
			break;
		case 4:
			emoji = "🐀 ";
			super.nome = "Rato";
			break;
		}
		color = ANSI_COLOR + emoji + ANSI_RESET;
		this.HEROI = color;
		
		setY(y);
		setX(x);
		
		matriz.setPosicao(x, y, this.HEROI);
	}

	public String getHeroi() {
		return HEROI;
	}
	
	public void mover(String comando) {
		
		int proximaLinha = getY();
		int proximaColuna = getX();
		
		if(comando.equalsIgnoreCase("up")) {
			proximaLinha = getY() - 1;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover(comando);
			setY(proximaLinha);
		}else if(comando.equalsIgnoreCase("down")) {
			proximaLinha = getY() + 1;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover(comando);
			setY(proximaLinha);
		}else if(comando.equalsIgnoreCase("right")) {
			proximaColuna = getX() + 1;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover(comando);
			setX(proximaColuna);
		}else if(comando.equalsIgnoreCase("left")) {
			proximaColuna = getX() - 1;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover(comando);
			setX(proximaColuna);
		}
		
		matriz.setPosicao(getY(), getX(), getHeroi());
		
		//Os obstáculos só irão se mover se a dificuldade for
		//no mínimo 2
		if(matriz.getDificuldade() > 1) {
			for(Obstaculo obstaculo: matriz.getObstaculos()) {
				obstaculo.mover(comando);
			}			
		}
	}
	
	//Método precisa ser concluído
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
			setX(getX() + 1);
		}else if(comando == 4) {
			setX(getX() - 1);
		}
		
		matriz.setPosicao(getY(), getX(), getHeroi());
		
	}

}