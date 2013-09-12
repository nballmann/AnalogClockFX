package org.nic.clock.model;

public class CityTime {
	
	private String city;
	private String timezone;
	private String timeRegion;
	private String country;
	private String longitude;

	private String localTime;
	
	public CityTime() {}
	
	public CityTime(String city, String timezone, String timeRegion, String country,
			String longitude, String localTime) {
		
		this.city = city;
		this.timezone = timezone;
		this.timeRegion = timeRegion;
		this.country = country;
		this.longitude = longitude;
		this.localTime = localTime;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the timeRegion
	 */
	public String getTimeRegion() {
		return timeRegion;
	}

	/**
	 * @param timeRegion the timeRegion to set
	 */
	public void setTimeRegion(String timeRegion) {
		this.timeRegion = timeRegion;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the localTime
	 */
	public String getLocalTime() {
		return localTime;
	}

	/**
	 * @param localTime the localTime to set
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityTime [city=" + city + ", timezone=" + timezone
				+ ", timeRegion=" + timeRegion + ", country=" + country
				+ ", longitude=" + longitude + ", localTime=" + localTime + "]";
	}

	

}
