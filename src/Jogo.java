import java.time.Instant;
import java.util.ArrayList;

/*
 * TO-DO List:
 *
 * Tirar o println da getRandom();
 * Retirar a Main
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
	 * O argumento deve ser a quantidade de números a menos do numero de cartas;
	 */
	private static int getRandom(int subtract){

		int instant = Instant.now().getNano() % (cards.size() - subtract);
		System.out.printf("Instant: %d %n", instant);
		return instant;
	}

	// Embaralha as cartas do vetor de cartas;
	private static void disorderCards(){

		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int i = 0; i < cards.size(); i++){
			temp.add(cards.remove((int)getRandom(i)));
			print();
		}

		cards = temp;
	}

	public static void print(){
		 
		for (int i : cards){
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		System.out.println("Hello World");
		getCards(12);
		print();
		disorderCards();
		print();
    
  	}
}
