package executaveis;

public class Matriz {

	private final int linhas;
	private final int colunas;
	private String[][] campo;
	private String objetivo;
	private int linhaObjetivo;
	private int colunaObjetivo;
	private int modoDeJogo;

	/*Construtor da classe matriz sempre terá 11 linhas
	 e 11 colunas, aí a área usável pelo robô vai ser
	 um quadrado de lado 5, como o PH pediu
	 */
	public Matriz() {
		this.linhas = 11;
		this.colunas = 11;
		
		campo = new String[linhas][colunas];
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				if(i == 5 & j == 5) {
					campo[i][j] = "+ ";
				}else if(i == 5) {
					campo[i][j] = "—— ";
				}
				else if(j == 5) {
					campo[i][j] = "|";
				}else {
					campo[i][j] = "   ";
				}
			}
		}
	}

	//Esse aqui vc sabe pra que serve
	public String toString() {
		String m = "";
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				m += campo[i][j];
			}
			m += "\n";
		}
		m += "\n";
		m += "————————————————————————————————————";
		return m;
	}

	//Esses dois eu coloquei só por padrão
	//mas acho que não precisa, talvez eu tire depois
	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	//NÃO usar no metodo main
	public void setPosicao(int linha, int coluna, String s) {
		campo[linha][coluna] = s;
	}
	
	/*Usar no método main, somente quando o usuário
	Informar onde irá se localizar o objetivo, deve-se usar
	imediatamente após instanciar a matriz, e só depois
 	instanciar o Robô, pois o robô vai ter como base
	o modo de jogo para ser definido qual personagem
	vai representá-lo*/
	@SuppressWarnings("unused")
	public void setModoDeJogo(int linha, int coluna, int modo) {
		/*Perguntar pro PH se pode deixar o objetivo 
		ficar numa posição gerada aleatoriamente, assim como
		os obstáculos*/
		final String ANSI_RESET = "\u001B[0m";
		String ANSI_COLOR = "\u001B[31m";
		switch(modo) {
		case 1:
			ANSI_COLOR = "\u001B[33m";
			objetivo = ANSI_COLOR + "🌽" + ANSI_RESET;
			break;
		case 2:
			ANSI_COLOR = "\u001B[31m";
			objetivo = ANSI_COLOR + "❤" + ANSI_RESET;
			break;
		case 3:
			ANSI_COLOR = "\u001B[32m";
			objetivo = "🦹‍♂️";
			break;
		case 4:
			ANSI_COLOR = "\u001B[33m";
			objetivo = ANSI_COLOR + "🧀" + ANSI_RESET;;
		}
		setPosicao(linha, coluna, objetivo);
		modoDeJogo = modo;
		
		/*Sempre vai colocar 2 obstáculos
		Caso tenha niveis de dificuldade,
		A quantidade pode aumentar*/
		Obstaculo o1 = new Obstaculo(this);
		Obstaculo o2 = new Obstaculo(this);
	}
	
	/*Usado para auxiliar no construtor da classe robo
	e da classe Obstaculo*/
	public int getModoDeJogo() {
		return modoDeJogo;
	}
	
	/*Preciso modificar algumas coisas nessa classe Matriz
	para dar usabilidade a esses métodos*/
	public int getColunaAlimento() {
		return colunaObjetivo;
	}
		
	public int getLinhaAlimento() {
		return linhaObjetivo;
	}
		
}
