package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgrammStart {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:/Users/finne/Desktop/ArkServerLogs/ShooterGame.log");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}

}