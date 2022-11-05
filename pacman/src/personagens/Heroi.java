package personagens;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import excecoes.*;
import matriz.Matriz;

public class Heroi extends Personagem{
	protected String heroi;
	protected String emoji;

	public Heroi(String color, Matriz matriz) {
		super(matriz);
		matriz.setHeroi(this);
		this.x = 5;
		this.y = 5;
		
		final String ANSI_RESET = "\u001B[0m";
		String ANSI_COLOR = "";
		
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
		
		boolean condicao1 = matriz.getModoDeJogo() == 1 || matriz.getModoDeJogo() == 5;
		boolean condicao2 = matriz.getModoDeJogo() == 2 || matriz.getModoDeJogo() == 6;
		boolean condicao3 = matriz.getModoDeJogo() == 3 || matriz.getModoDeJogo() == 7;
		boolean condicao4 = matriz.getModoDeJogo() == 4 || matriz.getModoDeJogo() == 8;
		
		if(condicao1) {
			emoji = "👨‍🌾 ";
			super.nome = "Fazendeiro";
		}else if(condicao2) {
			emoji = "🤖 ";
			super.nome = "Robô";
		}else if(condicao3) {
			emoji = "👮 ";
			super.nome = "Policial";
		}else if(condicao4) {
			emoji = "🐀 ";
			super.nome = "Rato";
		}
		
		color = ANSI_COLOR + emoji + ANSI_RESET;
		this.heroi = color;
		
		setY(y);
		setX(x);
		
		matriz.setPosicao(x, y, this.heroi);
	}

	public String getHeroi() {
		return heroi;
	}
	
	protected Heroi(Matriz matriz) {
		super(matriz);
	}
	
	
	public void mover(String comando) {
		
		int proximaLinha = getY();
		int proximaColuna = getX();
				
		if(comando.equalsIgnoreCase("up")) {
			proximaLinha--;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover();
		}else if(comando.equalsIgnoreCase("down")) {
			proximaLinha++;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover();
		}else if(comando.equalsIgnoreCase("right")) {
			proximaColuna++;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover();
		}else if(comando.equalsIgnoreCase("left")) {
			proximaColuna--;
			Validar.movimento(this, proximaLinha, proximaColuna);
			super.mover();
		}

		setX(proximaColuna);
		setY(proximaLinha);
		
		matriz.setPosicao(proximaLinha, proximaColuna, getHeroi());
		
		String posicaoHeroi = matriz.getCampo()[getY()][getX()];
		String posicaoObjetivo = matriz.getCampo()[matriz.getLinhaObjetivo()][matriz.getColunaObjetivo()];
		
		if(posicaoHeroi.equalsIgnoreCase(posicaoObjetivo)) {
			throw new VitoriaException();
		}
		
		if (matriz.getModoDeJogo() < 5) {
			for (Obstaculo obstaculo : matriz.getObstaculos()) {
				if (obstaculo.getX() == getX() && obstaculo.getY() == getY()) {
					matriz.setPosicao(proximaLinha, proximaColuna, obstaculo.getObstaculo());
					throw new GameOverException();
				}
			} 
		}
		//Os obstáculos só irão se mover se a dificuldade for
		//no mínimo 2
		if(matriz.getDificuldade() > 1) {
			for(Obstaculo obstaculo: matriz.getObstaculos()) {
				obstaculo.mover(comando);
			}			
		}
	}
	
	public void mover(int comando) {
		switch(comando) {
		case 1:
			this.mover("up");
			break;
		case 2:
			this.mover("down");
			break;
		case 3:
			this.mover("right");
			break;
		case 4:
			this.mover("left");
		}
		
	}
	
	//Usado somente na classe main que os robôs se moverem aleatoriamente
	public void mover() {

		Random random = new Random();
		int comando = random.nextInt(1, 5);
		Map<Integer, String> possibilidades;
		
		possibilidades = new HashMap<>();
		possibilidades.put(1, "up");
		possibilidades.put(2, "down");
		possibilidades.put(3, "right");
		possibilidades.put(4, "left");
		
		for(Entry<Integer, String> possibilidade: possibilidades.entrySet()){
			if(possibilidade.getKey() == comando) {
				this.mover(possibilidade.getValue());
				break;
			}
		}
	}

}