package models;

import org.junit.*;

import play.test.Helpers;
import play.test.WithApplication;

public class UserTest extends WithApplication {
	@Before
    public void setUp() {
		Helpers.inMemoryDatabase();
        start(Helpers.fakeApplication());
    }
	
	@Test
    public void testCreateAndRetrieveUser() {
        new User("bob@gmail.com", "Bob", "Smith", "secret").save();
        User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
        Assert.assertNotNull(bob);
        Assert.assertEquals("Bob", bob.firstName);
        Assert.assertEquals("Smith", bob.lastName);
        Assert.assertEquals("secret", bob.password);
    }
	
	@Test
    public void testAuthenticateUser() {
        new User("bob@gmail.com", "Bob", "Smith", "secret").save();
        
        Assert.assertNotNull(User.authenticate("bob@gmail.com", "secret"));
        Assert.assertNull(User.authenticate("bob@gmail.com", "badpassword"));
        Assert.assertNull(User.authenticate("tom@gmail.com", "secret"));
    }
	
	@Test
    public void testErrorOnDuplicateUsers() {
        new User("bob@gmail.com", "Bob", "Smith", "secret").save();
        try {
        	new User("bob@gmail.com", "Bob", "Smith", "secret").save();
        	Assert.fail("Can't have two users with the same user in the DB. Did you remove the ID field?");
        } catch (Exception e) {}
    }
}
