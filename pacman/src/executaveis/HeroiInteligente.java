package executaveis;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import excecoes.MovimentoInvalidoException;

public class HeroiInteligente extends Heroi{

	public HeroiInteligente(String color, Matriz matriz) {
		super(color, matriz);
	}
	
	private boolean condicao(int linhaAtual, int colunaAtual) {
		boolean condicao1 = matriz.getCampo()[linhaAtual][colunaAtual]
				.equalsIgnoreCase("   ");
		boolean condicao2 = matriz.getCampo()[linhaAtual][colunaAtual]
				.equalsIgnoreCase("+ ");
		boolean condicao3 = matriz.getCampo()[linhaAtual][colunaAtual]
				.equalsIgnoreCase("—— ");
		boolean condicao4 = matriz.getCampo()[linhaAtual][colunaAtual]
				.equalsIgnoreCase("| ");
		
		boolean condicao = condicao1 || condicao2 || condicao3 || condicao4;
		return condicao;
	}
	
	private String verificarEspacoLivre(String comando) {
		int livresNaDireita = 0;
		int livresNaEsquerda = 0;
		int livresAcima = 0;
		int livresAbaixo = 0;
		
		int linhaAtual = getY();
		int colunaAtual = getX();
		
		if (comando.equalsIgnoreCase("up")) {
			linhaAtual = getY() + 1;
			setY(linhaAtual);
		}else if (comando.equalsIgnoreCase("down")) {
			linhaAtual--;
			setY(linhaAtual);
		}else if (comando.equalsIgnoreCase("right")) {
			colunaAtual--;
			setY(colunaAtual);
		}else if (comando.equalsIgnoreCase("left")) {
			colunaAtual++;
			setY(colunaAtual);
		}
		
		//Verificando quantos espaços livres tem abaixo
		linhaAtual = getY() + 1;
		while (linhaAtual <= 5) {
			if(condicao(linhaAtual, colunaAtual)) {
				livresAbaixo++;
				linhaAtual++;
			}else {
				break;
			}
		}
		linhaAtual = getY();
		
		//Verificando quantos espaços livres tem acima
		linhaAtual = getY() - 1;
		while(linhaAtual > 0) {
			if(condicao(linhaAtual, colunaAtual)) {
				livresAcima++;
				linhaAtual--;
			}else {
				break;
			}
		}
		linhaAtual = getY();
		
		//Verificando quantos espaços livres à direita
		colunaAtual = getX() + 1;
		while (colunaAtual < 11) {
			if(condicao(linhaAtual, colunaAtual)) {
				livresNaDireita++;
				colunaAtual++;
			}else {
				break;
			}
		}
		colunaAtual = getX();
		
		//Verificando quantos espaços livres à esquerda
		colunaAtual = getX() - 1;
		while (colunaAtual >= 5) {
			if(condicao(linhaAtual, colunaAtual)) {
				livresNaEsquerda++;
				colunaAtual--;
			}else {
				break;
			}
		}
		colunaAtual = getX();
		
		List<Integer> livres = 
				Arrays.asList
				(livresNaDireita, livresNaEsquerda, livresAcima, livresAbaixo);
		
		int maisLivre = Collections.max(livres);
		
		Map<Integer, String> possibilidades = new HashMap<>();
		possibilidades.put(livresNaDireita, "right");
		possibilidades.put(livresNaEsquerda, "left");
		possibilidades.put(livresAcima, "up");
		possibilidades.put(livresAbaixo, "down");
		
		for(Entry<Integer, String> possibilidade: possibilidades.entrySet()) {
			if(possibilidade.getKey() == maisLivre) {
				return possibilidade.getValue();
			}
		}
		return null;
	}

	public void mover(String comando) {
		try {
			super.mover(comando);
		}catch(ArrayIndexOutOfBoundsException e) {
			super.mover(this.verificarEspacoLivre(comando));
		}catch(MovimentoInvalidoException m) {
			super.mover(this.verificarEspacoLivre(comando));
		}
	}
}
