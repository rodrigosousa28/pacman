package excecoes;

import executaveis.Heroi;
import executaveis.Matriz;
import executaveis.Obstaculo;

public class Validar {

	private Validar() {}
	
	public static boolean validar(Matriz m, int linha, int coluna) {
		if(coluna < 11 && coluna >= 0 && linha < 11 && linha >= 0) {
			boolean condicao1 = m.getCampo()[linha][coluna].equalsIgnoreCase("   ");
			boolean condicao2 = m.getCampo()[linha][coluna].equalsIgnoreCase("—— ");
			boolean condicao3 = m.getCampo()[linha][coluna].equalsIgnoreCase("|  ");
			boolean condicao4 = m.getCampo()[linha][coluna].equalsIgnoreCase("🐀 ");
			boolean condicao5 = m.getCampo()[linha][coluna].equalsIgnoreCase("👮 ");
			boolean condicao6 = m.getCampo()[linha][coluna].equalsIgnoreCase("🤖 ");
			boolean condicao7 = m.getCampo()[linha][coluna].equalsIgnoreCase("👨‍🌾 ");
			boolean podeIniciar = condicao1 || condicao2 || condicao3 || condicao4
					|| condicao5 || condicao6 || condicao7;
			return podeIniciar;
		}
		return false;
	}
	
	public static void movimento
	(Heroi heroi, int proximaLinha, int proximaColuna) {
		boolean dentroDasLinhasValidas = proximaLinha <= 5 && proximaLinha >= 0;
		boolean dentroDasColunasValidas = proximaColuna >= 5 && proximaColuna < 11;
		if(!(dentroDasLinhasValidas && dentroDasColunasValidas)) {
			throw new MovimentoInvalidoException(heroi.getNome());
		}
	}
	
	public static void movimentoObstaculo(String comando, Obstaculo obstaculo) {
		
		Matriz matriz = obstaculo.getMatriz();
		int linha = obstaculo.getY();
		int coluna = obstaculo.getX();
		boolean podeSubir = true;
		boolean podeDescer = true;
		boolean podeIrDireita = true;
		boolean podeIrEsquerda = true;
		
		
		if(comando.equalsIgnoreCase("up")) {
			linha--;
			podeSubir = Validar.validar(matriz, linha, coluna);
			if(!podeSubir) {
				throw new MovimentoInvalidoException(obstaculo.getNome());
			}
		}else if(comando.equalsIgnoreCase("down")) {
			linha++;
			podeDescer = Validar.validar(matriz, linha, coluna);
			if(!podeDescer) {
				throw new MovimentoInvalidoException(obstaculo.getNome());
			}
		}else if(comando.equalsIgnoreCase("left")) {
			coluna--;
			podeIrEsquerda = Validar.validar(matriz, linha, coluna);
			if(!podeIrEsquerda) {
				throw new MovimentoInvalidoException(obstaculo.getNome());
			}
		}else if(comando.equalsIgnoreCase("right")) {
			coluna++;
			podeIrDireita = Validar.validar(matriz, linha, coluna);
			if(!podeIrDireita) {
				throw new MovimentoInvalidoException(obstaculo.getNome());
			}
		}
	}
	
	public static void inicio(Matriz matriz, int linha, int coluna) {
		boolean podeIniciar = Validar.validar(matriz, linha, coluna);
		
		int linhaObjetivo = matriz.getLinhaObjetivo();
		int colunaObjetivo = matriz.getColunaObjetivo();
		
		boolean espacoObjetivo = linhaObjetivo == linha && colunaObjetivo == coluna;
		if(!podeIniciar || espacoObjetivo) {
			throw new InicioInvalidoException();
		}
	}
	
}