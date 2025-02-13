package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSum extends BeforeConditions{
    @Test(dataProvider = "LongTestData", dataProviderClass = DataProviders.class)
    public void testSumLong(long a, long b){
        long expected = a+b;
        Assert.assertEquals(calculator.sum(a, b), expected);

    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = DataProviders.class)
    public void testSumDouble(double a, double b){
        double expected = a+b;
        Assert.assertEquals(calculator.sum(a, b), expected);
    }
}
