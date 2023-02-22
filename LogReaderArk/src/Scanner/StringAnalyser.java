package Scanner;

public class StringAnalyser {
	
	public String Zeitstempel(String Line) {

		
		String Timestamp = "";
		
		char a = ' ';	
		
		int Length;
		int mode = 0;
		int Zustand = 0;
		
		Length = Line.length();
		
		for(int i = 0; i<Length; i++) {
			
			a = Line.charAt(i);
			
			switch(mode) {
				//---------------------------------------------------------------
				//Hier wird der Timestamp aus dem String gefiltert und bearbeitet
				//---------------------------------------------------------------
			case 0:
					//---------------------------------------------------------------------
					// Über die If Abfragen wird der Timestamp ins richtige Format geändert
					//---------------------------------------------------------------------
				if (a == '[' & Zustand == 0) {
					Zustand = 1;
					
				}else if(a == '.' & Zustand == 1) {
						//--------------------------------------------------
						// ersetzen der Punkte im Datum durch Spiegelstriche
						//--------------------------------------------------
					Timestamp = Timestamp + a;
					Timestamp = Timestamp.replace('.','-');
					
				}else if(a == '-') {
						//----------------------------------------
						// Übergang zwischen Datum- und Zeitangabe
						//----------------------------------------
					a = ' ';
					Timestamp = Timestamp + a;
					Zustand = 2;
				}else if(a == '.' & Zustand == 2) {
					
						//---------------------------------------------------------
						// Ersetzen der Punkte in der Zeitangabe durch Doppelpunkte
						//---------------------------------------------------------
					Timestamp = Timestamp + a;
					Timestamp = Timestamp.replace('.',':');
					
				}else if(a == ']') {
					mode = 1;
					
				}else {
					Timestamp = Timestamp + a;
				}
			break;
			
			case 1:
				return Timestamp;
			}
		}
		return Timestamp;
	}
	
	public String UserLogin(String Line) {
		
		String Result = "";
		String TimStam = "";
		String Num = "";
		String Message = "";
		String UserName = "";
		String JoinMessage = "";
		
		int Count = 0;
		int Zustand = 0;
		int LineLenght = 0;
		int MessageLength = 0;
		int mode = 0;
		
		char a = ' ';
		
		LineLenght = Line.length();
		
		for(int i = 0; i<LineLenght; i++) {
			a = Line.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ']') {
					Count = 0;
					mode = 1;
				}
				if(Count == 1) {
					TimStam = TimStam + a;
				}
				if(a == '[') {
					Count = 1;
				}
			break;
			case 1:
				if(a == ']') {
					Count = 0;
					mode = 2;
				}
				if(Count == 1) {
					Num = Num + a;
				}
				if(a == '[') {
					Count = 1;
				}
			break;
			case 2:
				Message = Message + a;
			break;
			}
			
		}	
		
		MessageLength = Message.length();
		mode = 0;
		TimStam = "";
		
		for(int i = 0; i<MessageLength; i++) {
			a = Message.charAt(i);
			
			switch(mode){
			case 0:
				if(a == ':') {
					mode = 1;
				}else {
					TimStam = TimStam + a;
				}
			break;
			case 1:
				if(a == ' ' && Zustand == 0) {
					mode = 2;
					Zustand = 1;
				}
			break;
			case 2:
				if(a == ' ' && Zustand == 1) {
					mode = 3;
				}else {
					UserName = UserName + a;
				}
			break;
			case 3:
				if(a == '!') {
					JoinMessage = JoinMessage + a;
					mode = 4;
				}else {
					JoinMessage = JoinMessage + a;
				}
			break;
			default:
				
			break;
			}
		}
		
		if(JoinMessage.equals("joined this ARK!")) {
			Result = UserName + " " + TimStam + " " + JoinMessage;
			return Result;
		}else {
			Result = "";
			return Result;
		}
		
	}
}
