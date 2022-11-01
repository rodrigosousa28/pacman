package executaveis;

public abstract class Personagem {

	protected int x;
	protected int y;
	@SuppressWarnings("unused")
	protected Matriz matriz;

	public Personagem(Matriz matriz) {
		this.matriz = matriz;
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
	
	//Optei por colocar essa parte do código aqui na super classe
	//porque é comum tanto ao Robô, como ao Obstáculo
	public void mover(String comando) {
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
