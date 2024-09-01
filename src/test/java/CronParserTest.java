import org.example.InvalidCronException;
import org.example.fieldParser.CronParser;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CronParserTest {

    private CronParser cronParser = new CronParser();;

    @Test
    public void testValidCronExpression1() throws Exception {
        String expression = "*/15 0 1,15 * 1-5 /usr/bin/find";
        List<String> result = cronParser.parseExpression(expression);
        assertEquals(6, result.size());
        assertEquals("minute        0 15 30 45", result.get(0));
        assertEquals("hour          0", result.get(1));
        assertEquals("day of month  1 15", result.get(2));
        assertEquals("month         1 2 3 4 5 6 7 8 9 10 11 12", result.get(3));
        assertEquals("day of week   1 2 3 4 5", result.get(4));
        assertEquals("command       /usr/bin/find", result.get(5));
    }

    @Test
    public void testValidCronExpression2() throws Exception {
        String expression = "*/15 2,4-6,9/3 1,15 * 1-5 /usr/bin/find";
        List<String> result = cronParser.parseExpression(expression);
        assertEquals(6, result.size());
        assertEquals("minute        0 15 30 45", result.get(0));
        assertEquals("hour          2 4 5 6 9 12 15 18 21", result.get(1));
        assertEquals("day of month  1 15", result.get(2));
        assertEquals("month         1 2 3 4 5 6 7 8 9 10 11 12", result.get(3));
        assertEquals("day of week   1 2 3 4 5", result.get(4));
        assertEquals("command       /usr/bin/find", result.get(5));
    }

    @Test
    public void testInvalidCronExpressionTooManyFields() {
        String expression = "*/15 0 1,15 * 1-5 /usr/bin/find extraField";
        InvalidCronException exception = assertThrows(InvalidCronException.class, () -> {
            cronParser.parseExpression(expression);
        });
        assertEquals("Expression is in-correct. Individual Fields should be seperated with single space. Supporting Minute,Hours,DaysOfMonth,Month,DaysOfWeek and Command in respective order", exception.getMessage());
    }

    @Test
    public void testInvalidCronExpressionTooFewFields() {
        String expression = "*/15 0 1,15 a 1-5";
        InvalidCronException exception = assertThrows(InvalidCronException.class, () -> {
            cronParser.parseExpression(expression);
        });
        assertTrue(exception.getMessage().contains("Please re-check the cron expression : a"));
    }

    @Test
    public void testInvalidCronExpressionInvalidCharacter() {
        String expression = "*/15 0 1,15 * *-5 /usr/bin/find";
        // Assuming the implementation of FieldParser throws InvalidCronException for invalid characters
        Exception exception = assertThrows(InvalidCronException.class, () -> {
            cronParser.parseExpression(expression);
        });
        assertTrue(exception.getMessage().contains("Please re-check the cron expression : *-5"));
    }
}