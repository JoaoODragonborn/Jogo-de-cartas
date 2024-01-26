import java.time.Instant;
import java.util.ArrayList;

/*
 * TO-DO List:
 *
 * Mudar de "int" para "Carta" no getCards e no disorderCards;
 * Escrever o getCards();
 *
 * */

class Jogo {
  
	//private static Carta[] cards;
	private static ArrayList<Integer> cards = new ArrayList<Integer>();
  
	// Coleta as cartas no arquivo cartas.txt e atribui a variavel estatica;
	private static void getCards(int n) {

		for(Integer i = 0; i < n; i++){
			cards.add(i);
		}
	}
	
	/* 
	 * Gera um valor aleatório com valores de 0 a (cards.size() - subtract);
	 * Feita apenas retornar um valor aleatório para a disorderCards();
	 * 
	 */
	private static int getRandom(){

		int instant = Instant.now().getNano() % (cards.size());
		return instant;
	}

	/* Embaralha as cartas do vetor de cartas;
	 * Pega um elemento de um ArrayList de indice pseudoaleatorio fornecido por getRandom()
	 * e joga dentro de outro ArrayList de indice ordenado;
	 */
	private static void disorderCards(){

		ArrayList<Integer> temp = new ArrayList<Integer>();
		int times = cards.size();
		for (int i = 0; i < times; i++){
			temp.add(cards.remove(getRandom()));
		}
		cards = temp;
	}
	
	// Imprime todos os elementos do ArrayList cards em uma linha;
	public static void print(){
		 
		for (int i : cards){
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
	
	// Teste dos métodos;
	public static void main(String[] args) {
	
		getCards(12);
		disorderCards();
		print();
    
  	}
}
