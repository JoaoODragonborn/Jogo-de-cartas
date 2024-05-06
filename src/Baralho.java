import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

class Baralho {
  
	private static ArrayList<Carta> cards = new ArrayList<Carta>();
	private static Scanner input;
  
	// Coleta as cartas no arquivo cartas.txt e atribui a variavel estatica;
	private static void openFile() {

		try{
		input = new Scanner(Paths.get("../doc/cartas.txt"));
		} catch (IOException ioe){
			System.out.println("Não foi possível encontrar as cartas. Confira se \"cartas.txt\" está dentro da pasta doc e tente jogar novamente.");
			System.exit(1);
		}
	}

	private static void collectCards(){
		try{
			while(input.hasNext()){
				cards.add(new Carta(input.next().trim(), input.next().trim(), input.nextInt(), input.next().trim(), input.nextInt()));
			}
		} catch(NoSuchElementException nsee){
			System.out.println("Arquivo \"cartas.txt\" mal formatado. Confira se as informações estão organizadas em todo o arquivo.");
			System.exit(2);
		} catch (IllegalStateException ise){
			System.out.println("Erro na leitura das cartas. Abortando.");
			System.exit(2);
		}
	}

	private static void closeFile(){
		if(input != null){
			input.close();
		}
	}
	
	/* 
	 * Gera um valor aleatório com valores de 0 a (cards.size() - subtract);
	 * Feita apenas retornar um valor aleatório para a disorderCards();
	 * 
	 */
	public static int getRandom(ArrayList<Carta> cards){

		int instant = Instant.now().getNano() % (cards.size());
		return instant;
	}

	/* Embaralha as cartas do vetor de cartas;
	 * Pega um elemento de um ArrayList de indice pseudoaleatorio fornecido por getRandom()
	 * e joga dentro de outro ArrayList de indice ordenado;
	 */
	public static ArrayList<Carta> disorderCards(ArrayList<Carta> cards){

		ArrayList<Carta> temp = new ArrayList<Carta>();
		int times = cards.size();
		for (int i = 0; i < times; i++){
			temp.add(cards.remove(getRandom(cards)));
		}
		return temp;
	}
	
	/* Imprime todos os elementos do ArrayList cards em uma linha;
	public static void print(){
		 
		for (Carta i : cards){
			System.out.printf("%s \n", i.getName());
		}
		System.out.println();
	}
	*/

	// Retorna o ArrayList das cartas após a coleta no arquivo e a desordenação;
	public static ArrayList<Carta> getCards() {
	
		openFile();
		collectCards();
		closeFile();
		return disorderCards(cards);
  	}
}
