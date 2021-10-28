package be.abis.exercise.model;


import java.time.LocalDate;


public class ConversionResult {

	//private Motd motd;
	//private boolean success;
    //private Query query;
    //private Info info;
    //private boolean historical;
	//@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	private double result;

	/*public Motd getMotd() {
		return motd;
	}

	public void setMotd(Motd motd) {
		this.motd = motd;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public boolean isHistorical() {
		return historical;
	}

	public void setHistorical(boolean historical) {
		this.historical = historical;
	}*/

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
