package hello;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // Тест для перевірки правильного результату
    @Test
    public void testAddition() {
        Expression e = new ExpressionBuilder("1+1").build();
        double result = e.evaluate();
        assertEquals(2.0, result, "1+1 should be result");
    }

    // Тест, який завжди буде видавати помилку
//    @Test
//    public void testSubtractionFail() {
//        Expression e = new ExpressionBuilder("5-1").build();
//        double result = e.evaluate();
//        assertEquals(2.0, result, "5-1 should not be result (this test will fail)");
//    }
}