package executaveis;

public abstract class Personagem {

	protected int x;
	protected int y;
	@SuppressWarnings("unused")
	private Matriz matriz;

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
	
	public abstract void mover(String comando);
	
	public abstract void mover(int comando);
}
