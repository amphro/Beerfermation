package controllers;

import models.HopDefinition;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.hops;
import views.html.login;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render(HopDefinition.find.all()));
    }
    
    public static Result hops() {
    	return ok(hops.render(HopDefinition.find.all()));
    }
    
    public static Result login() {
        return ok(
            login.render()
        );
    }
  
}
