package jogo;

public class Carta{

	// Counter é a carta que essa carta vence;
	
	private final String name;
	private final String counter;
	private final int power;
	private final String type;
	private final int magic;

	// A magia das cartass é definida apartir da hierarquia das magias,
	// magias mais fortes tem o nível de magia mais alto.
	// Os níveis de magia da magia mais forte 
	// e da magia mais fraca devem ser 8 e 0 respectivamente.

	Carta(String name, String counter, int power, String type, int magic){
		
		this.name = name;
		this.counter = counter;
		this.power = power;
		this.type = type;
		this.magic = magic;
	
	}
	
	String getName(){
		
		return this.name;
	
	}
	int getPower(){
		
		return this.power;
	
	}
	String getType(){
		
		return this.type;
	
	}
	String getCounter(){
		
		return this.counter;
	
	}

	int getMagic(){
	
		return this.magic;
	}

	void print(){
	

	}

	public int batalha(Carta rival){
		
		// Esse objeto é vencedor até que se prove o contrário;
		// Quem será o vencedor por padrão depende de como está definido na main.
		// Retorna 0 se esse objeto é o vencedor, 1 se esse objeto é o perdedor.
		
		int winner = 0;

		// if(this.counter == rival.getName()){ winner = 0; }
		if(this.name == rival.getCounter())
		{
			winner = 1;
			System.out.println("Counter\n");
		}
		
		else if(this.power < rival.getPower())
		{
			winner = 1;
			System.out.println("Poder\n");
		}	
		
		// else if(this.power > rival.getPower()){}
		else if(this.magic < rival.getMagic())
		{
			winner = 1;
			System.out.println("Magia\n");
		}
		// else {}

		return winner;
	}

}
