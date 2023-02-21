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
		
		int Count = 0;
		int Count2 = 0;
		int LineLenght = 0;
		int mode = 0;
		
		boolean joiningMessage = false;
		
		char a = ' ';
		
		LineLenght = Line.length();
		
		for(int i = 0; i<LineLenght; i++) {
			a = Line.charAt(i);
			
			switch(mode){
			case 0:
				if (Count == 2 && Count2 < 3) {
					Count = 0;
					Result = "";
				}
				
				if(a == '[' || a == ']') {
					Count = Count + 1;
					Count2 = Count2 + 1;
				}
				
				if(Count2 > 2) {
					Result = Result + a;
				}
				
				if(Count2 > 3 && Result.equals("[953]")) {
					Result = Result + " ";
					mode = 1;
				}else if(Count2 > 3){
					Result = "";
				}
				
			break;
			case 1:
				Result = Result + a;
			break;
			}
			
		}	
		
		return Result;
	}
}
