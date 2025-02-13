package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMult extends BeforeConditions{
    @Test(dataProvider = "LongTestData", dataProviderClass = DataProviders.class)
    public void testMultLong(long a, long b){
            long expected = a*b;
            Assert.assertEquals(calculator.mult(a, b), expected);

    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = DataProviders.class)
    public void testMultDouble(double a, double b){
            double expected = a*b;
            Assert.assertEquals(calculator.mult(a, b), expected);
        }
    }
