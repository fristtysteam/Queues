import java.time.LocalDate;
import java.time.Month;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoundedPriorityQueueSetTest {
    private BoundedPriorityQueueSet queue;
    private Task task1;
    private Task task2;
    private Task task3;

    @BeforeEach
    public void setUp() {
        Queue<Task> tasks = new PriorityQueue<Task>();
        queue = new BoundedPriorityQueueSet(3, tasks);
        task1 = new Task("Bob", "Task 1", LocalDate.of(2025, Month.MARCH, 24));
        task2 = new Task("Charlie", "Task 2", LocalDate.of(2026, Month.JANUARY, 25));
        task3 = new Task("Dave", "Task 3", LocalDate.of(2027, Month.MARCH, 26));
    }
    

    @Test
    public void testSize() {
        assertEquals(0, queue.size());

        queue.add(task1);
        assertEquals(1, queue.size());

        queue.add(task2);
        assertEquals(2, queue.size());

        queue.add(task3);
        assertEquals(3, queue.size());
    }
@Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.add(task1);
        assertFalse(queue.isEmpty());

        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyV3() {
        assertTrue(queue.isEmptyV3());

        queue.add(task1);
        assertFalse(queue.isEmptyV3());

        queue.remove();
        assertTrue(queue.isEmptyV3());
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull());

        queue.add(task1);
        assertFalse(queue.isFull());

        queue.add(task2);
        assertFalse(queue.isFull());

        queue.add(task3);
        assertTrue(queue.isFull());
    }

    @Test
    public void testIsFullV2() {
        assertFalse(queue.isFullV2());

        queue.add(task1);
        assertFalse(queue.isFullV2());

        queue.add(task2);
        assertFalse(queue.isFullV2());

        queue.add(task3);
        assertTrue(queue.isFullV2());
    }

    @Test
    public void testClearIfFull() {
        queue.add(task1);
        queue.add(task2);
        queue.add(task3);

        assertTrue(queue.isFull());
        queue.clearIfFull();
        assertFalse(queue.isFull());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAdd() {
        assertEquals(0, queue.add(task1));
        assertEquals(1, queue.add(task2));
        assertEquals(2, queue.add(task3));
    }

    @Test
    public void testAddWhenFull() {
        queue.add(task1);
        queue.add(task2);
        queue.add(task3);

        assertEquals(-1, queue.add(new Task("Eve", "Task 4", LocalDate.now().plusDays(3))));
    }

    @Test
    public void testAddDuplicateTask() {
        queue.add(task1);
        queue.add(task2);
        queue.add(task3);

        assertEquals(-1, queue.add(new Task("Charlie", "Task 2", LocalDate.now().plusDays(1))));
    }

    @Test
    public void testPeekWhenEmpty() {
        assertEquals(null, queue.peek());
    }

    @Test
    public void testPeek() {
        queue.add(task2);
        queue.add(task1);
        queue.add(task3);

        assertEquals(task2, queue.peek());
    }
}