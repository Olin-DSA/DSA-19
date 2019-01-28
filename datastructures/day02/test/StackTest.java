import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import your_code.MyStack;

public class StackTest {

    private MyStack stack;

    /**
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        stack = new MyStack();
        stack.push(1);
        stack.push(4);
        stack.push(2);
    }

    /**
     * Tests functionality of the stack
     */
    @Test
    public void testStack() {
        stack.push(3);
        int e = (int) stack.pop();
        assertEquals(e, 3);

        int bigNumber = 6;
        stack.push(bigNumber);

        assertEquals(stack.isEmpty(), false);
        stack.pop();
        stack.pop();
        stack.pop();
        e = (int) stack.pop();
        assertEquals(e, 1);

        assertEquals(stack.isEmpty(), true);
    }

    /**
     * Tests maxElement functionality
     */
    @Test
    public void testMax() {
        stack.push(3);
        assertEquals((int) stack.maxElement(), 4);
        stack.pop();

        int bigNumber = 6;
        stack.push(bigNumber);
        assertEquals((int) stack.maxElement(), bigNumber);

        stack.pop();
        assertEquals((int) stack.maxElement(), 4);
        stack.pop();
        assertEquals((int) stack.maxElement(), 4);
        stack.pop();
        assertEquals((int) stack.maxElement(), 1);
    }

}
