package ireporter.report;

import org.testng.Assert;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

@Test
@Listeners(value=ClassImplementingIReporter.class)
public class IReporterReport {

    @Test(description="testReporterOne")
    public void A(){
        Assert.assertTrue(true);
    }

    @Test(description="testReporterTwo")
    public void B(){
        Assert.assertTrue(false);
    }
    
    @Test(description="testReporterThree")
    public void testReporterThree(){
        Assert.assertTrue(false);
    }

}