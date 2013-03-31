package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import play.db.ebean.Model;

public class RecipeDefinition extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
	
	@Id
	public Long id;
	public String name;
	public List<HopInstance> hops;

	public RecipeDefinition(String name) {
		this(name, new ArrayList<HopInstance>());
	}
	
	public RecipeDefinition(String name, List<HopInstance> hops) {
		this.name = name;
		this.hops = hops;
	}
}
