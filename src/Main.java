package jogo;
import java.util.Scanner;
  
public class Main {

	public static Carta[] criaCartas(int loops){
    
		Scanner entrada = new Scanner(System.in);
		Carta[] cartas = new Carta[loops];
    
		for(int i = 0; i < loops; i++){
			System.out.println("Digite o nome, qual carta ela countera, seu poder, seu tipo e sua magia. Se a carta não possui um dos atributos, digite 0.\n");
        		cartas[i] = new Carta(entrada.next(), entrada.next(), entrada.nextInt(), entrada.next(), entrada.nextInt());
    		}

		entrada.close();
		return cartas;    
	} // Fim da criaCartas
	
	// Tenho uma duvida sincera que é: Seria melhor eu colocar quase todos os statements 
	// dessa função dentro de um do-while para que a mesma se reinicie até que o usuário 
	// decida parar a aplicação, ou seria melhor fazer recursão? Faz diferença? 
	// Empilhar a recursão vai custar memória? Quanto?
	public static void menu(){
  
		 Scanner entrada = new Scanner(System.in);
   		 int option;
		 int partidas;
	   	 Carta[] cartas;
    
		 System.out.println("Escolha uma das opções:\n 1 - Jogar\n 2 - Cadastrar cartas\n 3 - Sair\n");
    
	   	 do{
	
 		 	option = entrada.nextInt();
	     	 } 
     		 while(option < 1 || option > 3);
    
		 if (option == 2){
			 System.out.println("Digite a quantidade de cartas a serem cadastradas./n");
			 cartas = criaCartas(entrada.nextInt());
      
	   	 } else if (option == 1){
		       	 System.out.println("Quantas partidas?\n");
			 partidas = entrada.nextInt();
			 //partida(partidas, cartas);
			 entrada.close();

		 } else {
			 System.out.println("Até mais!\n");
			 entrada.close();
	 
		 }
	} // Fim do menu


	public static void main(String[] args) {
  
		menu();
    
	} // Fim da main
	
} // Fim da classe
