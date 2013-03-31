package models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

public class HopInstance extends Model {
	private static final long serialVersionUID = 1L;
	
	public static Finder<Long, HopInstance> find = new Finder<Long, HopInstance>(Long.class, HopInstance.class);
	
	@Id
    public Long id;
	@ManyToOne
	public HopDefinition hop;
	public double amount;
	public double alpha;
	public double beta;

	public HopInstance(HopDefinition hop, double amount) {
		this(hop, amount, hop.getAlpha().getMid(), hop.getBeta().getMid());
	}
	
	public HopInstance(HopDefinition hop, double amount, double alpha, double beta) {
		this.hop = hop;
		this.amount = amount;
		this.alpha = alpha;
		this.beta = beta;
	}
}
