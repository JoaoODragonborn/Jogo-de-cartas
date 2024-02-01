import java.util.Dictionary;
import java.util.Hashtable;
public class Batalha{

/*
 * TO-DO List:
 * 
*/

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
      System.out.println(confronto(new Carta("Vara_de_Pesca", null, 0, "Relicario", 0), new Carta("Excalibur", "Caldeirao", 300, "Lendaria", 0), new Carta("Shuriken", "Guizo", 200, "Lendaria", 0)).getName());
    }
}