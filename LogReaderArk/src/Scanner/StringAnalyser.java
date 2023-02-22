package Scanner;

public class StringAnalyser {
	
	public String Zeitstempel(String Line) {

		
		String timeStamp = "";
		
		char a = ' ';	
		
		int length;
		int mode = 0;
		int zustand = 0;
		
		length = Line.length();
		
		for(int i = 0; i<length; i++) {
			
			a = Line.charAt(i);
			
			switch(mode) {
				//---------------------------------------------------------------
				//Hier wird der timeStamp aus dem String gefiltert und bearbeitet
				//---------------------------------------------------------------
			case 0:
					//---------------------------------------------------------------------
					// Über die If Abfragen wird der timeStamp ins richtige Format geändert
					//---------------------------------------------------------------------
				if (a == '[' & zustand == 0) {
					zustand = 1;
					
				}else if(a == '.' & zustand == 1) {
						//--------------------------------------------------
						// ersetzen der Punkte im Datum durch Spiegelstriche
						//--------------------------------------------------
					timeStamp = timeStamp + a;
					timeStamp = timeStamp.replace('.','-');
					
				}else if(a == '-') {
						//----------------------------------------
						// Übergang zwischen Datum- und Zeitangabe
						//----------------------------------------
					a = ' ';
					timeStamp = timeStamp + a;
					zustand = 2;
				}else if(a == '.' & zustand == 2) {
					
						//---------------------------------------------------------
						// Ersetzen der Punkte in der Zeitangabe durch Doppelpunkte
						//---------------------------------------------------------
					timeStamp = timeStamp + a;
					timeStamp = timeStamp.replace('.',':');
					
				}else if(a == ']') {
					mode = 1;
					
				}else {
					timeStamp = timeStamp + a;
				}
			break;
			
			case 1:
				return timeStamp;
			}
		}
		return timeStamp;
	}
	
	public String UserLogin(String Line) {
		
		String result = "";
		String timStam = "";
		String num = "";
		String message = "";
		String userName = "";
		String joinMessage = "";
		
		int count = 0;
		int zustand = 0;
		int lineLenght = 0;
		int messagelength = 0;
		int mode = 0;
		
		char a = ' ';
		
		lineLenght = Line.length();
		
		for(int i = 0; i<lineLenght; i++) {
			a = Line.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ']') {
					count = 0;
					mode = 1;
				}
				if(count == 1) {
					timStam = timStam + a;
				}
				if(a == '[') {
					count = 1;
				}
			break;
			case 1:
				if(a == ']') {
					count = 0;
					mode = 2;
				}
				if(count == 1) {
					num = num + a;
				}
				if(a == '[') {
					count = 1;
				}
			break;
			case 2:
				message = message + a;
			break;
			}
			
		}	
		
		messagelength = message.length();
		mode = 0;
		timStam = "";
		
		for(int i = 0; i<messagelength; i++) {
			a = message.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ':') {
					mode = 1;
				}else {
					timStam = timStam + a;
				}
			break;
			case 1:
				if(a == ' ' && zustand == 0) {
					mode = 2;
					zustand = 1;
				}
			break;
			case 2:
				if(a == ' ' && zustand == 1) {
					mode = 3;
				}else {
					userName = userName + a;
				}
			break;
			case 3:
				if(a == '!') {
					joinMessage = joinMessage + a;
					mode = 4;
				}else {
					joinMessage = joinMessage + a;
				}
			break;
			default:
				
			break;
			}
		}
		
		if(joinMessage.equals("joined this ARK!")) {
			result = userName + " " + timStam + " " + joinMessage;
			return result;
		}else {
			result = "";
			return result;
		}
		
	}
	
public String UserLogout(String Line) {
		
		String result = "";
		String timStam = "";
		String num = "";
		String message = "";
		String userName = "";
		String leaveMessage = "";
		
		int count = 0;
		int zustand = 0;
		int lineLenght = 0;
		int messagelength = 0;
		int mode = 0;
		
		char a = ' ';
		
		lineLenght = Line.length();
		
		for(int i = 0; i<lineLenght; i++) {
			a = Line.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ']') {
					count = 0;
					mode = 1;
				}
				if(count == 1) {
					timStam = timStam + a;
				}
				if(a == '[') {
					count = 1;
				}
			break;
			case 1:
				if(a == ']') {
					count = 0;
					mode = 2;
				}
				if(count == 1) {
					num = num + a;
				}
				if(a == '[') {
					count = 1;
				}
			break;
			case 2:
				message = message + a;
			break;
			}
			
		}	
		
		messagelength = message.length();
		mode = 0;
		timStam = "";
		
		for(int i = 0; i<messagelength; i++) {
			a = message.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ':') {
					mode = 1;
				}else {
					timStam = timStam + a;
				}
			break;
			case 1:
				if(a == ' ' && zustand == 0) {
					mode = 2;
					zustand = 1;
				}
			break;
			case 2:
				if(a == ' ' && zustand == 1) {
					mode = 3;
				}else {
					userName = userName + a;
				}
			break;
			case 3:
				if(a == '!') {
					leaveMessage = leaveMessage + a;
					mode = 4;
				}else {
					leaveMessage = leaveMessage + a;
				}
			break;
			default:
				
			break;
			}
		}
		
		if(leaveMessage.equals("left this ARK!")) {
			result = userName + " " + timStam + " " + leaveMessage;
			return result;
		}else {
			result = "";
			return result;
		}
		
	}
}
