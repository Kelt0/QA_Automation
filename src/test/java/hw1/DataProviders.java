package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "DoubleTestData")
    public Object[][] doubleTestData(){
        return new Object[][]{{12.4,2.3},
                {3.1, 4.6},
                {4.1, 2.9},
                {0.0, 0.0},
                {-8.1, -1.9}};
    }

    @DataProvider(name = "LongTestData")
    public static Object[][] longTestData(){
        return new Object[][]{{1L,2L},
                {321L, 432L},
                {43L, 43L},
                {0, 0},
                {-3L, -6L}};
    }


}
