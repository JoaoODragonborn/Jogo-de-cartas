import java.time.Instant;

class Teste {
  public static void main(String[] args) {

    int n = 3, n1, ins;
    String[] nums = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] neonums = new String[12];
    ins = Instant.now().getNano();
    
    for (int i = 0; i < 10; i++){
    	
	    
	    
	    
	n1 = ins/1000;
    	System.out.println(ins%n1);
    }
    
    
  }

}
