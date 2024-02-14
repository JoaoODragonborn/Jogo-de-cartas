import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
/*
TO DO:  fazer algum padrão decente de jogadas do CPU (método batalha)
	a vara de pesca só trocar durante o confronto faz com que a 
	nova carta não seja representada quando impressa
*/
public class Batalha{

	static private ArrayList<Carta> cartas;
	static private ArrayList<Carta> oponente = new ArrayList<Carta>();
    static private ArrayList<Carta> jogador = new ArrayList<Carta>();
    static private final Scanner entrada = new Scanner(System.in);
    static private char continuar;
    static private int vencedor; // CPU = 0, jogador = 1;
    static private int[] pontos = {0, 0, 0, 0}; // Pontos na rodada CPU Jogador, Pontos totais CPU Jogador
    static private int partidas = 0;
    static private int cartaEscolhida;
    static private final String traco = "-";
  
    private static void embaralharCartas(){
    	if(partidas == 0){  
    		cartas = Baralho.getCards();
	    } else {
    		cartas = Baralho.disorderCards(cartas);
    	}
	}

  	private static void distribuirCartas(){
    	for(int i = 0; i < 7; i++){
	    	jogador.add(cartas.get(i*2));
    	 	oponente.add(cartas.get(i*2+1));
    	}
	}
  
  	private static void scanCarta(){

		try{
    		cartaEscolhida = entrada.nextInt() - 1; 

	    } catch(InputMismatchException ime){		
    	    scanCarta();
    	}

	    if (!(cartaEscolhida >= 0 && cartaEscolhida <= jogador.size())){
        scanCarta();
    	}
  	}

  	private static void scanContinuar(){

    	System.out.println("Deseja continuar? (S/N)");
    
	    try{
    		continuar = entrada.next().charAt(0); 

	    } catch(InputMismatchException ime){		
    		scanContinuar();
    	}

	    if (!(continuar == 'S' || continuar == 's' || continuar == 'N'|| continuar == 'n')){
    		scanContinuar();
	    }
	}
  
	public static void printDeque(){
		int index;
		int qtdCartas = 7;
		int qtdCartasPorLinha = 4;
		System.out.println("\nEscolha sua carta:");
	
		// Duas linhas de cartas;
		for(int j = 0; j < 2; j++){
	
			// Parte de cima das cartas;
			for(int i = 0; i < qtdCartasPorLinha; i++){
				System.out.printf("|%s| ", traco.repeat(23)); 
			}
	
			System.out.println();
	
			// Informações das cartas;
			for(index = 0; index < qtdCartasPorLinha; index++){
	
				if(j == 0){	
					System.out.printf("|%-19s %-3d| ", jogador.get(index).getName(), jogador.get(index).getPower());
				} else {
					System.out.printf("|%-19s %-3d| ", jogador.get(index + 4).getName(), jogador.get(index+ 4).getPower());
				
				}
			}
		
			System.out.println();
		
			// Parte de baixo das cartas (msm de cima);
			for(int i = 0; i < qtdCartasPorLinha; i++){
		
					System.out.printf("|%s| ", traco.repeat(23)); 
			}
		
			System.out.println();
		
			// Número da carta a ser escolhida pelo jogador;
			for(int i = 1; i <= qtdCartas; i++){
		
				if(j == 0){
					// Mostra os números da primeira linha;
					System.out.printf("%13d%s", i , " ".repeat(12)); 
		
				} else {
					// Mostra os números da segunda linha;
					System.out.printf("%13d%s", i + 4, " ".repeat(12)); 
				}
		
				if (i == 4){
					System.out.println();
					break;
				}
			}
		
			System.out.println();
		
		// A primeira linha terá 4 cartas e a segunda terá 3 cartas;
		qtdCartasPorLinha--;
		}

	} // Fim do método printDeque()

    public static void batalha(){


      	do{
	
        	embaralharCartas();
			distribuirCartas();
	//--------------------------------------------
			for(int i = 0; i < 7; i++){
				if(partidas == 0){
					System.out.println("Decidindo quem começa...");
         			vencedor = Baralho.getRandom(cartas) < 14 ? 0 : 1;
		    	}

	        	if(vencedor == 0){
    	    
					//CPU começa
		        	System.out.println("CPU começa!");
         			System.out.printf("|%s|    |%s|\n", traco.repeat(23), traco.repeat(23));
         			System.out.printf("|%-19s %3d| VS |   Escolha sua carta   |\n", 
                            oponente.get(0).getName(), oponente.get(0).getPower());
          			System.out.printf("|%s|    |%s|\n", traco.repeat(23), traco.repeat(23));
		        	printDeque();
	            	scanCarta();
      		    	vencedor = confronto(jogador.get(cartaEscolhida), oponente.get(0), cartas.get(15));
        
				} else {
	       	 		// Jogador começa
	    	    	System.out.println("Você começa!");
    	    		printDeque();
	    	    	scanCarta();
    	   			// CPU escolhe carta
					vencedor = confronto(jogador.get(cartaEscolhida), oponente.get(0), cartas.get(15));
        		}

        		jogador.remove(cartaEscolhida);
	        	oponente.remove(0);
        
				// Imprime quem venceu a rodada
        		if (vencedor == 0){
	       			System.out.println("CPU venceu a rodada!");
			 		pontos[0]++;
		        } else {	
    				System.out.println("Você venceu a rodada!");
					pontos[1]++;
	       		}

			} // Fim das sete partidas 
	
			// Imprime quem venceu a partida
			if (pontos[0] < pontos[1]){
	
				System.out.println("Você venceu a partida!");
				pontos[2]++;
	
			} else {
			
				System.out.println("CPU venceu a partida!");
				pontos[3]++;
			}

			// Limpa os decks do jogador e do CPU
			oponente.clear();
			jogador.clear();
			// Zera os pontos da rodada
			pontos[0] = 0;
			pontos[1] = 0;

		//---------------------------------------------------------
        	scanContinuar();
        
		} while(continuar == 's' || continuar == 'S');

		// Imprime o resultado final. Se o jogador perder, é zoado.
		System.out.printf("Pontuação final:\nCPU %d VS %d Vocẽ\n", pontos[2], pontos[3]);
    
		if(pontos[2] < pontos[3]){
		
			System.out.println("Parabéns");

		} else {
	
			System.out.println("GG easy, lixo");

		}

    }
  
    public static int confronto(Carta jogador, Carta oponente, Carta topo){
      	// Imprime a arena
      
      	System.out.printf("|%s|    |%s|\n", traco.repeat(23), traco.repeat(23));
      	System.out.printf("|%-19s %3d| VS |%-19s %3d|\n", oponente.getName(), oponente.getPower(), jogador.getName(), jogador.getPower());
	    System.out.printf("|%s|    |%s|\n", traco.repeat(23), traco.repeat(23));
      
      	// Batalha!
      	// Verifica se alguma das cartas é a Vara_de_Pesca
      	if(jogador.getName() == "Vara_de_Pesca"){
        	jogador = topo;
      	} else if(oponente.getName() == "Vara_de_Pesca"){
        	oponente = topo;
      	}
      	// Verifica se uma das cartas countera a outra
      	if(jogador.getName() == oponente.getCounter()){
        	return 1;
      	} else if(jogador.getCounter() == oponente.getName()){
        	return 0;
      	}
      	// Usa o switch-case pra ver qual é o tipo de carta do jogador;
      	// Dentro do case, verifica qual é o tipo de carta do oponente e
      	// para cada tipo de carta ou cada exceção, aplica um algoritmo 
      	// que define como a batalha será decidida.
      
      	switch (jogador.getType()){
        
			// A carta do jogador é Magia:
        	case "Magia":
          	
				// Se a carta do oponente for o escudo magico, o jogador foi de base.
		        if (oponente.getName() == "Escudo_Magico"){
        		    return 0;
        
				// Se a carta do oponente for Magia:
		        } else if (oponente.getType() == "Magia"){
        		    return jogador.getMagic() > oponente.getMagic() ? 1 : 0; 
		
				// Se a carta do oponente for relicario, arma branca ou lendaria:
        		} else{
		            return jogador.getPower() > oponente.getPower() ? 1 : 0;
    	      	}

	       	case "Relicario":
          		if (oponente.getType() == "Relicario"){
		            Dictionary<String, Integer> relics = new Hashtable<>();
        		    relics.put("Caldeirao", 200);
		            relics.put("Escudo_Magico", 10);
        		    relics.put("Guizo", 300);
		            relics.put("Quebra_Espadas", 500);
        		    relics.put("Escudo", 9);

            		return relics.get(jogador.getName()) > relics.get(oponente.getName()) ? 1 : 0;
            
	          	} else {
		            return jogador.getPower() > oponente.getPower() ? 1 : 0;
        		}

	        default:
          		return jogador.getPower() > oponente.getPower() ? 1 : 0;
      
		}
    } // Fim do método
} // Fim da classe
