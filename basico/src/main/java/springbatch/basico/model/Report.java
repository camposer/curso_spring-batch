package springbatch.basico.model;

/**
 * SQL SCHEMMA
 * CREATE TABLE RAW_REPORT(`DATE` VARCHAR(50), IMPRESSIONS VARCHAR(50), CLICKS VARCHAR(50), EARNING VARCHAR(50)); *
 */
public class Report {
	private String Date;
	private String Impressions;
	private String Clicks;
	private String Earning;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getImpressions() {
		return Impressions;
	}
	public void setImpressions(String impressions) {
		Impressions = impressions;
	}
	public String getClicks() {
		return Clicks;
	}
	public void setClicks(String clicks) {
		Clicks = clicks;
	}
	public String getEarning() {
		return Earning;
	}
	public void setEarning(String earning) {
		Earning = earning;
	}
}
