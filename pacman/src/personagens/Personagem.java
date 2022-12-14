package personagens;

import matriz.Matriz;

public abstract class Personagem {

	protected int x;
	protected int y;
	protected String nome;
	protected Matriz matriz;

	public Personagem(Matriz matriz) {
		this.matriz = matriz;
	}
	
	protected Personagem() {}

	public String getNome() {
		return nome;
	}
	
	public Matriz getMatriz() {
		return matriz;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/*Optei por colocar essa parte do código aqui na super classe
	porque é comum tanto ao Herói, como ao Obstáculo
	Basicamente, esse comando faz o personagem sumir da posição atual,
	Antes de se mover*/
	public void mover() {
		if(getY() != 5 && getX() != 5) {
			matriz.setPosicao(getY(), getX(), "   ");
		}else if(getY() == 5 && getX() == 5) {
			matriz.setPosicao(getY(), getX(), "+ ");						
		}else if(getY() == 5) {
			matriz.setPosicao(getY(), getX(), "—— ");						
		}else if(getX() == 5) {
			matriz.setPosicao(getY(), getX(), "|  ");
		}
	}
	
	public abstract void mover(int comando);
}
