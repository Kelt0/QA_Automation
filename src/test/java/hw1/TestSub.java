package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSub extends BeforeConditions{
    @Test(dataProvider = "LongTestData", dataProviderClass = DataProviders.class)
    public void testSubLong(long a, long b){
        long expected = a-b;
        Assert.assertEquals(calculator.sub(a, b), expected);

    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = DataProviders.class)
    public void testSubDouble(double a, double b){
        double expected = a-b;
        Assert.assertEquals(calculator.sub(a, b), expected);
    }
}
