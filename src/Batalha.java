import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ArrayList;
public class Batalha{

/*
 * TO-DO List:
 * 
*/
	public static void printDeque(ArrayList<Carta> cards){
		int index;
		int qtdCartas = 7;
		int qtdCartasPorLinha = 4;
		String traco = "-";
		// Duas linhas de cartas;
		for(int j = 0; j < 2; j++){
			// Parte de cima das cartas;
			for(int i = 0; i < qtdCartasPorLinha; i++){
				System.out.printf("|%s| ", traco.repeat(23)); 
			}
			// Informações das cartas;
			for(index = 0; index < qtdCartasPorLinha; index++){
				System.out.printf("|%-19s %3d|", cards.get(index).getName(), cards.get(index).getPower());
			}
			// Parte de baixo das cartas (msm de cima);
			for(int i = 0; i < qtdCartasPorLinha; i++){
				System.out.printf("|%s| ", traco.repeat(23)); 
			}
			// Número da carta a ser escolhida pelo jogador;
			for(int i = 0; i < qtdCartas; i++){
				if(j == 0){
					// Mostra os números da primeira linha;
					System.out.printf("%d", i + 1); 
				} else {
					// Mostra os números da segunda linha;
					System.out.printf("%13d%s", i + 5, " ".repeat(12)); 
				}
			}
		// A primeira linha terá 4 cartas e a segunda terá 3 cartas;
		qtdCartasPorLinha--;
		}

	}

    public static void batalha(){}
  
    public static Carta confronto(Carta jogador, Carta oponente, Carta topo){
      // Verifica se alguma das cartas é a Vara_de_Pesca
      if(jogador.getName() == "Vara_de_Pesca"){
        jogador = topo;
      } else if(oponente.getName() == "Vara_de_Pesca"){
        oponente = topo;
      }
      // Verifica se uma das cartas countera a outra
      if(jogador.getName() == oponente.getCounter()){
        return jogador;
      } else if(jogador.getCounter() == oponente.getName()){
        return oponente;
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
            return oponente;
          // Se a carta do oponente for Magia:
          } else if (oponente.getType() == "Magia"){
            return jogador.getMagic() > oponente.getMagic() ? jogador : oponente; 
          // Se a carta do oponente for relicario, arma branca ou lendaria:
          } else{
            return jogador.getPower() > oponente.getPower() ? jogador : oponente;
          }
        case "Relicario":
          if (oponente.getType() == "Relicario"){
            Dictionary<String, Integer> relics = new Hashtable<>();
            relics.put("Caldeirao", 200);
            relics.put("Escudo_Magico", 10);
            relics.put("Guizo", 300);
            relics.put("Quebra_Espadas", 500);
            relics.put("Escudo", 9);

            return relics.get(jogador.getName()) > relics.get(oponente.getName()) ? jogador : oponente;
            
          } else if(oponente.getType() == "Arma_Branca" || oponente.getType() == "Lendaria" || oponente.getType() == "Magia"){
            return jogador.getPower() > oponente.getPower() ? jogador : oponente;
          }
          break;
        case "Arma_Branca":
          if (oponente.getName() == "Escudo"){
            return oponente;
          } else {
            return jogador.getPower() > oponente.getPower() ? jogador : oponente;
          }
        default:
          return jogador.getPower() > oponente.getPower() ? jogador : oponente;
      
      }
      // Refatorar
      return jogador;
    }

    public static void main(String[] args){
    	//printDeque();
    }
}
