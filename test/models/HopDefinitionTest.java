package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.test.Helpers;
import play.test.WithApplication;

public class HopDefinitionTest extends WithApplication {
	@Before
    public void setUp() {
		Helpers.inMemoryDatabase();
        start(Helpers.fakeApplication());
    }
	
	@Test
    public void testCreateAndRetrieve() {
        new HopDefinition("Ahtanum", "TestDesc", 5.7, 6.3, 5.0, 6.5).save();
        HopDefinition a = HopDefinition.find.where().eq("name", "Ahtanum").findUnique();
        Assert.assertNotNull(a);
        Assert.assertEquals("Ahtanum", a.name);
        Assert.assertEquals("TestDesc", a.description);
        Assert.assertEquals(5.7, a.alphaLow, .01);
        Assert.assertEquals(6.3, a.alphaHigh, .01);
        Assert.assertEquals(5.0, a.betaLow, .01);
        Assert.assertEquals(6.5, a.betaHigh, .01);
    }
}
