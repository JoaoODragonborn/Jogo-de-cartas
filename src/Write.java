import java.util.Scanner;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.lang.SecurityException;
import java.io.FileNotFoundException;


public class Write{

	private static Formatter output;

	public static void main(String[] args){
		openFile();
		addRecords();
		closeFile();
	}

	public static void openFile(){

		try{
			output = new Formatter("cartas.txt");
		} catch (SecurityException se) {
			System.out.println("Não é possível acessar o arquivo.");
			System.exit(1);
		} catch (FileNotFoundException fnfe){
			System.out.println("Arquivo não encontrado.");
			System.exit(2);
		}
	
	}

	public static void addRecords(){
		Scanner input = new Scanner(System.in);
		System.out.println("Digite as informações das cartas: ");

		while(input.hasNext()){
			try{
			output.format("%s %s %d %s %d %n", input.next(), input.next(), input.nextInt(), input.next(), input.nextInt());
			} catch (FormatterClosedException fce){
				System.out.println("Erro na inscrição do arquivo.");
				break;
			} catch (NoSuchElementException nsee){
				System.out.println("Entrada inválida.");
			}
		}
	}
	public static void closeFile(){
		if(output != null){
			output.close();
		}
	}
}
