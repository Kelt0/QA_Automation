package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDivide extends BeforeConditions{
    @Test(dataProvider = "LongTestData", dataProviderClass = DataProviders.class)
    public void testDivideLong(long a, long b){
        try{
            long expected = a/b;
            Assert.assertEquals(calculator.div(a, b), expected);
        } catch (ArithmeticException e){
            System.out.println("Деление на ноль");
        }
    }

    @Test(dataProvider = "DoubleTestData", dataProviderClass = DataProviders.class)
    public void testDivideDouble(double a, double b){
        try{
            double expected = a/b;
            Assert.assertEquals(calculator.div(a, b), expected);
        } catch (Exception e){
            System.out.println("Деление на ноль");
        }
    }
    }


