package controllers;

import models.HopDefinition;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.brew;
import views.html.hops;
import views.html.index;
import views.html.login;

public class Application extends Controller {
	
	public static class Login {
	    public String email;
	    public String password;

	    public String validate() {
	        if (User.authenticate(email, password) == null) {
	          return "Invalid user or password";
	        }
	        return null;
	    }
	}
  
	public static User getUser() {
		String id = request().username();
		if (id != null) {
			return User.find.byId(id);
		}
		return null;
	}
	
    public static Result index() {
        return ok(index.render(getUser()));
    }
    
    public static Result hops() {
    	return ok(hops.render(getUser(), HopDefinition.find.all()));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result brew() {
    	return ok(brew.render(getUser()));
    }
    
    public static Result login() {
    	return ok(
            login.render(Form.form(Login.class))
        );
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
    
    public static Result authenticate() {
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                routes.Application.index()
            );
        }
    }
}
