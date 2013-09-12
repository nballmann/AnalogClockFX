package org.nic.clock.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.nic.clock.model.CityTime;

public final class TimeZoneUtil {

	public static final String FILE_URL = "res/cities.txt";
		
	public static HashMap<String, CityTime> readFile(final String file) {
		
		BufferedReader reader;
		
		String line;
		
		String sep = "\",|,\"";
		
		try {
			
			reader = new BufferedReader(new FileReader(file));
			
			HashMap<String, CityTime> cityTimeMap = new HashMap<String, CityTime>();
			
			while ((line = reader.readLine()) != null) {
				
				CityTime temp = new CityTime();
				
				String[] entry = line.split(sep);
				
				temp.setCity(entry[0].replace("\"", ""));
				entry[1].replace("\"", "");
				String[] timeZoneRegion = entry[1].split("\\)"); 
				temp.setTimezone(timeZoneRegion[0].replace("(", "").replace("\"", ""));
				temp.setTimeRegion(timeZoneRegion[1].trim());
				
				temp.setCountry(entry[2].replace("\"", ""));
				temp.setLongitude(entry[3].replace("\"", ""));
				temp.setLocalTime(entry[4].replace("\"", ""));
				
				cityTimeMap.put(temp.getCity(), temp);
				
			}
			
			reader.close();
			
			return cityTimeMap;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	
}
