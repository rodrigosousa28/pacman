package executaveis;

public class Teste {

	public static void main(String[] args) {
		
		Matriz m = new Matriz();
		m.setModoDeJogo(2, 8, 4);
		Robo r = new Robo("preto", m);
		System.out.println(m);
		r.mover("up");
		System.out.println(m);
		r.mover("right");
		System.out.println(m);
		r.mover("left");
		System.out.println(m);
		r.mover("down");
		System.out.println(m);
	}
}
