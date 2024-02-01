public class Carta{

	// Counter é a carta que essa carta vence;
	
	private String name;
	private String counter;
	private int power;
	private String type;
	private int magic;

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
	
  public String getName(){
		
		return this.name;
	
	}
  
  public String getCounter(){

    return this.counter;

  }
  
  public int getPower(){
		
		return this.power;
	
	}
  
	String getType(){
		
		return this.type;
	
	}
	
	public int getMagic(){
	
		return this.magic;
	}

  public void setAttributes(String name, String counter, int power, String type, int magic){
    this.name = name;
    this.counter = counter;
    this.power = power;
    this.type = type;
    this.magic = magic;
  }
  
	void print(){
	
  }
}
