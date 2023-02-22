package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgrammStart {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:\\Users\\finne\\git\\ArkLogReader\\ServerGame.log");
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file);
		Scanner scan3 = new Scanner(file);
		StringAnalyser timestamp = new StringAnalyser();
		
		String Output = "";
		String Zeit = "";
		String userLogin = "";
		String userLogout = "";
		
		while(scan.hasNextLine()) {
			Zeit = timestamp.Zeitstempel(scan.nextLine());
			userLogin = timestamp.UserLogin(scan2.nextLine());
			userLogout = timestamp.UserLogout(scan3.nextLine());
			
			if(!userLogin.equals("")) {
				Output = userLogin;
				System.out.println(Output);
			}
			
			if(!userLogout.equals("")) {
				Output = userLogout;
				System.out.println(Output);
			}
		}
		
		scan.close();
		scan2.close();
		scan3.close();
	}

}
