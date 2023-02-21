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
}
