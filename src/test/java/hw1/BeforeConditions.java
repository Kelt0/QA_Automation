package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class BeforeConditions {
    public Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }
}

