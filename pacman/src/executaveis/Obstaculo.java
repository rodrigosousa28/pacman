package executaveis;

import java.util.Random;

import excecoes.GameOverException;
import excecoes.InicioInvalidoException;
import excecoes.MovimentoInvalidoException;
import excecoes.Validar;

public class Obstaculo extends Personagem{
	
	private String obstaculo;

	public Obstaculo(Matriz matriz) {
		super(matriz);
	}
	
	public Obstaculo() {
		super();
	}
	
	public void setMatriz(Matriz matriz) {
		super.matriz = matriz;
		Random random = new Random();
		int linhaObstaculo = random.nextInt(11);
		int colunaObstaculo = random.nextInt(11);
		
		setY(linhaObstaculo);
		setX(colunaObstaculo);
		
		try {
			Validar.inicio(matriz, linhaObstaculo, colunaObstaculo);
		} catch (InicioInvalidoException e) {
			setMatriz(matriz);
			System.out.println("tentando dnv...");
		}
		
		final String ANSI_COLOR;
		final String ANSI_RESET = "\u001B[0m";
		
		switch(matriz.getModoDeJogo()) {
		case 1:
			ANSI_COLOR = "\u001B[36m";
			obstaculo = ANSI_COLOR + "🐺 " + ANSI_RESET;
			nome = "Lobo";
			break;
		case 2:
			obstaculo = "🧙‍♀️‍ ";
			nome = "Bruxa";
			break;
		case 3:
			ANSI_COLOR = "\u001B[32m";
			obstaculo = ANSI_COLOR + "🧟 " + ANSI_RESET;
			nome = "Zumbi";
			break;
		case 4:
			obstaculo = "🐈 ";
			nome = "Gato";
			break;
		}
		matriz.setPosicao(getY(), getX(), obstaculo);
	}
	
	/*O parâmetro passado aqui será o mesmo que o que foi
	passado no robô, mas o obstáculo não vai seguir exatamente 
	esse comando, ou seja, se o comando for up, o obstaculo so 
	vai subir se ele estiver abaixo do robô.
	Ou seja, ele vai agir de acordo com o que o robô agir
	mas levando em consideração o contexto
	Falta corrigir alguns bugs*/
	public void mover(String comando) {
		try {
			Validar.movimentoObstaculo(comando, this);
			super.mover();
			if(comando.equalsIgnoreCase("up")) {
				//Quer dizer que o robô está acima
				if(matriz.getRobo().getY() < this.getY()) {
					this.setY(getY() - 1);
				//Quer dizer que o robô está abaixo
				}else {
					this.setY(getY() + 1);				
				}
			}else if(comando.equalsIgnoreCase("down")) {
				//Quer dizer que o robô está acima
				if(matriz.getRobo().getY() < this.getY()) {
					this.setY(getY() - 1);
				//Quer dizer que o robô está abaixo
				}else {
					this.setY(getY() + 1);				
				}
			}else if(comando.equalsIgnoreCase("right")) {
				//Quer dizer que o robô está a direita
				if(matriz.getRobo().getX() > this.getX()) {
					this.setX(getX() + 1);
				//Quer dizer que o robô está a esquerda ou na mesma coluna
				}else {
					this.setX(getX() - 1);
				}
			}else if(comando.equalsIgnoreCase("left")) {
				//Quer dizer que o robô está a direita
				if(matriz.getRobo().getX() > this.getX()) {
					this.setX(getX() + 1);
					//Quer dizer que o robô está a esquerda ou na mesma coluna
				}else {
					this.setX(getX() - 1);
				}	
			}	
			matriz.setPosicao(getY(), getX(), obstaculo);
		}catch(MovimentoInvalidoException e) {}
		if(matriz.getRobo().getX() == this.getX() && matriz.getRobo().getY() == this.getY()) {
			throw new GameOverException();
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

	public String getObstaculo() {
		return obstaculo;
	}
	
	
}
