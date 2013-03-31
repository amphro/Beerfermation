package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class HopDefinition extends Model {
	private static final long serialVersionUID = 1L;
	
	public static Finder<String, HopDefinition> find = new Finder<String, HopDefinition>(String.class, HopDefinition.class);
	
	@Id
	public String name;
	@Column(columnDefinition="LONGTEXT")
	public String description;
	public double alphaLow;
	public double alphaHigh;
	public double betaLow;
	public double betaHigh;
	
	public HopDefinition(String name, String description, double alphaLow, double alphaHigh, double betaLow, double betaHigh) {
		this.name = name;
		this.description = description;
		this.alphaLow = alphaLow;
		this.alphaHigh = alphaHigh;
		this.betaLow = betaLow;
		this.betaHigh = betaHigh;
	}
	
	public Range getAlpha() {
		return new Range(alphaLow, alphaHigh);
	}
	
	public Range getBeta() {
		return new Range(betaLow, betaHigh);
	}
	
	public static class Range {
		private double low;
		private double high;
		
		Range(Double low, Double high) {
			this.low = low;
			this.high = high;
		}
		
		public double getLow() {
			return this.low;
		}
		
		public double getHigh() {
			return this.high;
		}
		
		public double getMid() {
			return (this.high + this.low) / 2;
		}
	}
}
