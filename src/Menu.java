import java.util.Scanner;
import java.util.InputMismatchException;
  
public class Menu {

	static int option;
	static int tries = 0;
	
	private static void brincadeira(){
	
		tries++;
	
		if (tries == 10){
			System.out.println("Vai se danar, eu desisto de vc!");
			System.exit(10);
		} else if (tries == 9){
			System.out.println("Muito legal saber que além de ir se divertir, " +
				       "ir conversar com seus amigos ou fazer algo de útil, " +
				       "vc está aqui testando como vou me comportar se vc " + 
				       "escrever algo de errado. Digita logo uma das opções " +
				       "que te dei ou vá à merda.\n");
		} else if (tries == 7){
			System.out.println("Vc se acha mt engraçadinho, né?\n");
		} else if (tries % 3 == 0){
			System.out.println("Eu acredito que vc seja mais inteligente do " + 
					"que isso. Digite alguma das opçoes que te dei.\n");
		} else {
			System.out.println("Ops, paraece que vc digitou algo errado. As " + 
					"opções são 1 ou 2. Caso queira jogar, digite 1, caso " + 
					"não queira jogar, digite 2.\n");
		}
	}
	
	private static void scanOption(){
		
		Scanner entrada = new Scanner(System.in);
    System.out.println("Bem vindo ao jogo de cartas de viado. Você quer jogar agora?\n" + 
			"1 - Sim!\n2 - Não :(");
    
		try{
			option = entrada.nextInt(); 

		} catch(InputMismatchException ime){

			brincadeira();		
			scanOption();
		}
		
		if (option != 1 || option != 2){
			brincadeira();		
			scanOption();
		}
		//if(entrada != null){
		entrada.close();	
		//}
	}
	
	private static void menu(){
  	int parImpar;
		scanOption();
		
		if (option == 1){
      Batalha.batalha();
		} else {
			System.out.println("Até mais!\n");
		}
    
	} // Fim do menu
	
	public static void main(String[] args){
		menu();
	}
	
} // Fim da classe
