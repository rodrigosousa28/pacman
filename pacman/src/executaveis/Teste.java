package executaveis;

public class Teste {

	public static void main(String[] args) {
		
		Matriz m = new Matriz();
		m.setModoDeJogo(3, 1);
		Heroi r = new Heroi("preto", m);
		System.out.println(m);
		try {
			r.mover("left");			
		}catch(MovimentoInvalidoException moov) {
			System.out.println(moov.getMessage());
		}
		r.mover("up");
		System.out.println(m);
		r.mover("right");
		System.out.println(m);
		r.mover("left");
		System.out.println(m);
		try {
			r.mover("left");			
		}catch(MovimentoInvalidoException moov) {
			System.out.println(moov.getMessage());
		}
		System.out.println(m);
		r.mover("down");
	}
}
