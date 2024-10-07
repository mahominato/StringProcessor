import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {
    private final StringProcessor sp = new StringProcessor();

    @Test
    public void testIsStrongPassword() {
        assertTrue(sp.isStrongPassword("StrongP@ss1"));
        assertFalse(sp.isStrongPassword("weakpass"));
        assertFalse(sp.isStrongPassword("12345678"));
        assertFalse(sp.isStrongPassword("WeakPass1"));
        assertFalse(sp.isStrongPassword("WeakPass!"));
    }

    @Test
    public void testCalculateDigits() {
        assertEquals(3, sp.calculateDigits("There are 3 apples and 5 oranges."));
        assertEquals(0, sp.calculateDigits("No digits here!"));
        assertEquals(2, sp.calculateDigits("Room 101"));
        assertEquals(1, sp.calculateDigits("I have 1 dog."));
        assertEquals(4, sp.calculateDigits("2024 is a year with 4 seasons."));
    }

    @Test
    public void testCalculateWords() {
        assertEquals(5, sp.calculateWords("Hello world this is Java"));
        assertEquals(0, sp.calculateWords(""));
        assertEquals(1, sp.calculateWords("SingleWord"));
        assertEquals(3, sp.calculateWords("One Two   Three"));
        assertEquals(2, sp.calculateWords("   Leading spaces"));
    }

    @Test
    public void testCalculateExpression() {
        assertEquals(7.0, sp.calculateExpression("3 + 4"));
        assertEquals(12.0, sp.calculateExpression("3 + 4 * 2"));
        assertEquals(3.0, sp.calculateExpression("(1 + 2)"));
        assertEquals(0.5, sp.calculateExpression("1 / 2"));
        assertEquals(15.0, sp.calculateExpression("10 + 5"));
    }
}
