package Scanner;

public class StringAnalyser {
	
	public String Zeitstempel(String Line) {
		
		String Analyzed = "";
		char a;	
		int Length;
		boolean timestamp = false;
		
		Length = Line.length();
		
		for(int i = 0; i<Length; i++) {
			a = Line.charAt(i);
			if (a==']' & timestamp == false) {
				Analyzed = Analyzed + a;
				Analyzed = Analyzed.replace('[',' ');
				Analyzed = Analyzed.replace(']',' ');
				Analyzed = Analyzed.replace('-',' ');
				return Analyzed;
			} else {
				Analyzed = Analyzed + a;
			}
		}
		return Analyzed;
	}
}
