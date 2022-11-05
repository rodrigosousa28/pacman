package executaveis;

import java.util.Random;

import excecoes.GameOverException;
import excecoes.InicioInvalidoException;
import excecoes.MovimentoInvalidoException;
import excecoes.MovimentoInvalidoObstaculoException;
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
		
		try {
			Validar.inicio(matriz, linhaObstaculo, colunaObstaculo);
		} catch (InicioInvalidoException e) {
			setMatriz(matriz);
		}
		
		setY(linhaObstaculo);
		setX(colunaObstaculo);

		final String ANSI_COLOR;
		final String ANSI_RESET = "\u001B[0m";
		
		switch(matriz.getModoDeJogo()) {
		case 1:
			obstaculo = "🐺 ";
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
		int linhaAtual = getY();
		int colunaAtual = getX();
		
		try {
			Validar.movimentoObstaculo(comando, this);
			super.mover();
			if(comando.equalsIgnoreCase("up")) {
				//Quer dizer que o robô está acima
				if(matriz.getHeroi().getY() < this.getY()) {
					linhaAtual--;
				//Quer dizer que o robô está abaixo
				}else {
					linhaAtual++;
				}
			}else if(comando.equalsIgnoreCase("down")) {
				//Quer dizer que o robô está acima
				if(matriz.getHeroi().getY() < this.getY()) {
					linhaAtual--;
				//Quer dizer que o robô está abaixo
				}else {
					linhaAtual++;
				}
			}else if(comando.equalsIgnoreCase("right")) {
				//Quer dizer que o robô está a direita
				if(matriz.getHeroi().getX() > this.getX()) {
					colunaAtual++;
				//Quer dizer que o robô está a esquerda ou na mesma coluna
				}else {
					colunaAtual--;
				}
			}else if(comando.equalsIgnoreCase("left")) {
				//Quer dizer que o robô está a direita
				if(matriz.getHeroi().getX() > this.getX()) {
					colunaAtual++;
					//Quer dizer que o robô está a esquerda ou na mesma coluna
				}else {
					colunaAtual--;
				}	
			}
			
			if(matriz.getCampo()[linhaAtual][colunaAtual] == matriz.getCampo()[matriz.getLinhaObjetivo()][matriz.getColunaObjetivo()]) {
				throw new MovimentoInvalidoObstaculoException();
			}
			
			//Só vai realizar o movimento se não gerar a exceção
			setX(colunaAtual);
			setY(linhaAtual);

			matriz.setPosicao(getY(), getX(), obstaculo);
		}catch(MovimentoInvalidoException e) {}
		if(matriz.getHeroi().getX() == this.getX() && matriz.getHeroi().getY() == this.getY()) {
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
