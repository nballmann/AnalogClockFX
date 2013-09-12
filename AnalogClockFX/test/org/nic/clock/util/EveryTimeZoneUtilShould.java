package org.nic.clock.util;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.nic.clock.model.CityTime;

public class EveryTimeZoneUtilShould {

	private HashMap<String, CityTime> cityMap;
	
	@Before
	public void init() {
		
 		
		cityMap = TimeZoneUtil.readFile(TimeZoneUtil.FILE_URL);
		
	}
	
	@Test
	public void LoadAndParseAGivenFileSource() {
		
		for(Map.Entry<String, CityTime> entry : cityMap.entrySet()) {
			
			System.out.println("Key: " + entry.getKey() + " " + entry.getValue().toString());
			
		}
		
		assertTrue(TimeZoneUtil.readFile(TimeZoneUtil.FILE_URL) != null);
		
	}
	
	@Test
	public void ReturnATimeZoneBySpecifiedCity() {
		
		final String city = "Hannover";
		System.out.println(cityMap.get(city).getTimezone());
		String timezone = cityMap.get(city).getTimezone();
		
		assertEquals("GMT+01:00", timezone);
		
	}
	
	
	
	
	
}
