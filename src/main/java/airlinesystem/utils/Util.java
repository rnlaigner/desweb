package airlinesystem.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class Util
{	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static NumberFormat nf = NumberFormat.getInstance(new Locale("pt","BR"));

	static
	{	nf.setMaximumFractionDigits (2);	   // O default é 3.
		nf.setMinimumFractionDigits (2);
		nf.setGroupingUsed(false);
	}

	public static boolean dataValida(String umaData)
	{	try
		{	if(umaData.length() != 10) return false;
		
			Integer.parseInt(umaData.substring(0,2));
			Integer.parseInt(umaData.substring(3,5));
			Integer.parseInt(umaData.substring(6,10));
		
			sdf.setLenient(false);
			sdf.parse(umaData);
			return true; 
		}
		catch(Exception e)
		{	return false;
		} 
	}

	public static Date strToDate(String umaData)
	{	int dia = Integer.parseInt(umaData.substring(0,2));
		int mes = Integer.parseInt(umaData.substring(3,5));
		int ano = Integer.parseInt(umaData.substring(6,10));

		return java.sql.Date.valueOf(ano + "-" + mes + "-" + dia);
	}
	
	public static Date strToDateUS(String umaData)
	{	int mes = Integer.parseInt(umaData.substring(0,2));
		int dia = Integer.parseInt(umaData.substring(3,5));
		int ano = Integer.parseInt(umaData.substring(6,10));

		return java.sql.Date.valueOf(ano + "-" + mes + "-" + dia);
	}

	public static Calendar strToCalendar(String umaData)
	{
		int dia = Integer.parseInt(umaData.substring(0, 2));
		int mes = Integer.parseInt(umaData.substring(3, 5));
		int ano = Integer.parseInt(umaData.substring(6, 10));

		Calendar data = new GregorianCalendar(ano, mes - 1, dia);
		return data;
	}
	
	public static Timestamp strToTimestamp(String umaData)
	{	int dia = Integer.parseInt(umaData.substring(0,2));
		int mes = Integer.parseInt(umaData.substring(3,5));
		int ano = Integer.parseInt(umaData.substring(6,10));

		int hh = Integer.parseInt(umaData.substring(11,13));
		int mi = Integer.parseInt(umaData.substring(14, 16));
		int ss = Integer.parseInt(umaData.substring(17,19));

		return Timestamp.valueOf(ano + "-" + mes + "-" + dia + " " + hh + ":" + mi + ":" + ss);
	}

	public static String dateToStr(java.sql.Date umaData)
	{	return sdf.format(umaData);
	}
	
	public static String dateToStr(java.util.Date umaData)
	{	return sdf.format(umaData);
	}
	
	public static String milisecondsToDate(long milliseconds)
	{
		int seconds = (int) (milliseconds / 1000) % 60 ;
		int minutes = (int) ((milliseconds / (1000*60)) % 60);
		int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
		
		return String.valueOf(hours + ":" + minutes + ":" + seconds);
	}

	public static String calendarToStr(Calendar umaData)
	{
		if (umaData == null)
			return "";
		else
			return sdf.format(umaData.getTime());
	}

	public static double strToDouble(String valor)
		throws NumberFormatException
	{	if (valor == null || "".equals(valor))
		{	return 0;
		}
		else   
		{	return Double.parseDouble(valor);
		}		
	}
	
	public static String doubleToStr(double valor)
	{	return nf.format(valor);
	}	
	
	public static List<String> convertCommaListToArray(String outboundSeats) {
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