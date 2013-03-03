import java.util.List;

import models.HopDefinition;
import models.User;
import play.Application;
import play.GlobalSettings; 
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {
	@Override
    public void onStart(Application app) {
        // Check if the database is empty
        if (User.find.findRowCount() == 0) {
            Ebean.save((List) Yaml.load("initial-data.yml"));
        }
        
        //For now, just delete all the current hops, add add them 
        //from the yml file. Eventually, we will probably only want
        //to add new hops from the yml that don't already exist in
        //the database, so if we add some from production, they 
        //don't get deleted. Although, then we can't update information
        //in the yml, unless we only the ones that are in the yml.
        Ebean.delete(HopDefinition.find.all());
        Ebean.save((List) Yaml.load("hops.yml"));
    }
}