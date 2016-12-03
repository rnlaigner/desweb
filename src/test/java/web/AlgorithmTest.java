package web;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmTest {
	
	public static void main(String args[]){
		String string = "12,1,34,16";
		
		List<String> array = convertCommaListToArray(string);
		
		for(String str : array){
			System.out.println(str);
		}
	}
	
	
	private static List<String> convertCommaListToArray(String outboundSeats) {
		List<String> array = new ArrayList<String>();
		
		int stringLength = outboundSeats.length();
		int i = 0;
		int start = i;
		while (i < stringLength)
		{
			
			i = getBreakPosition(outboundSeats,i);
			array.add(outboundSeats.substring(start, i));
			i++;
			start = i;
		}
		return array;
	}
	
	private static int getBreakPosition(String outboundSeats, int startPosition){
		int i;
		for(i = startPosition; i < outboundSeats.length(); i++){
			if(outboundSeats.charAt(i)==','){
				return i;
			}
		}
		return i;
	}
	
}
