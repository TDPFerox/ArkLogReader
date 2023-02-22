package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgrammStart {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:\\Users\\finne\\git\\ArkLogReader\\ServerGame.log");
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file);
		StringAnalyser timestamp = new StringAnalyser();
		
		String Output = "";
		String Zeit = "";
		String User = "";
		
		while(scan.hasNextLine()) {
			Zeit = timestamp.Zeitstempel(scan.nextLine());
			User = timestamp.UserLogin(scan2.nextLine());
			
			if(Zeit.equals("") || User.equals("")) {
				
			}else{
				Output = User;
				System.out.println(Output);
			}
		}
		
		scan.close();
		scan2.close();
	}

}
