import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Read{
	
	private static Scanner input;

	public static void main(String[] args){
	
		openFile();
		readFile();
		closeFile();
	}
	
	public static void openFile(){
		try{
			input = new Scanner(Paths.get("cartas.txt"));
		} catch(IOException ioe){
			System.out.println("Erro ao abrir o arquivo.");
			System.exit(1);
		}
	}

	public static void readFile(){
		System.out.printf("%-10s%-10s%-10s%-10s%-10s %n", "Name", "Counter", "Power", "Type", "M.Power");

		try{
			while(input.hasNext()){
				System.out.printf("%-10s%-10s%-10d%-10s%-10d %n", input.next(), input.next(), input.nextInt(), input.next(), input.nextInt());
			}
		} catch(NoSuchElementException nsee){
			System.out.println("O texto ta zoado.");
			System.exit(2);
		} catch(IllegalStateException ise){
			System.out.println("Erro na leitura.");
			System.exit(2);
		}
	}

	public static void closeFile(){
		if(input != null){
			input.close();
		}
	}

}
