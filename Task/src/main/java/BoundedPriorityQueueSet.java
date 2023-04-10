
import java.util.NoSuchElementException;
import java.util.Queue;
/**

BoundedPriorityQueueSet is a priority queue that can hold a limited number of Tasks. If a Task is added and the queue

is already full, the Task with the earliest deadline is removed from the queue to make room for the new Task. The

queue is implemented as a standard Queue and the priority is based on the deadline of the Task.
*/
public class BoundedPriorityQueueSet extends Task {

    protected int maxSize;
    protected Queue<Task> queue;

  /**

Constructs a new BoundedPriorityQueueSet object with a specified maximum size and a Queue to store Tasks.
@param maxSize the maximum number of Tasks that the queue can hold
@param queue the Queue used to store Tasks
*/

    public BoundedPriorityQueueSet(int maxSize, Queue<Task> queue) {
        this.maxSize = 10;
        this.queue = queue;
    }
    
    /**

Constructs a new BoundedPriorityQueueSet object with a default maximum size of 10.
*/

    public BoundedPriorityQueueSet() {
        this.maxSize = 10;
    }
/**

Returns the number of Tasks currently in the queue.
@return the number of Tasks in the queue
*/
    public int size() {
        return queue.size();
    }

    /**

Returns true if the queue is empty, false otherwise.
@return true if the queue is empty, false otherwise
*/
    public boolean isEmpty() {
        if (queue.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
/**

Prints "queue is not empty" if the queue is not empty, and "queue is empty" otherwise.
*/
    public void isEmptyV2() {
        if (!queue.isEmpty()) {
            System.out.println("queue is not empty");;
        } else {
            System.out.println("queue is empty");
        }
    }
/**

Returns true if the queue is empty, false otherwise.
@return true if the queue is empty, false otherwise
*/
    public boolean isEmptyV3() {
        return queue.isEmpty();
    }

    /**

Returns true if the queue is full, false otherwise.
@return true if the queue is full, false otherwise
*/
    public boolean isFull() {
        return queue.size() <= maxSize;
    }
/**

Returns true if the queue is full, false otherwise.
@return true if the queue is full, false otherwise
*/
    public boolean isFullV2() {
        if (queue.size() >= maxSize) {
            return true;
        } else {

            return false;
        }
    }
/**

Clears the queue if it is full.
*/
    public void clearIfFull() {
        if (isFull() == true) {
            queue.clear();

        }
        System.out.println("queue is now clear");
    }
/**

Adds a task to the queue.

@param task the task to add to the queue.

@return the index of the added task in the queue.

@throws IllegalStateException if the queue is already full.

@throws DuplicateElementException if the task already exists in the queue.
*/
    public int add(Task task) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }

        if (queue.contains(task)) {
            throw new DuplicateElementException("Task already exists in queue.");
        }
        boolean isAdded = queue.offer(task);

        if (!isAdded) {
            throw new IllegalStateException("failed to add to the queue");
        }
        return queue.size() - 1;
    }
/**

Retrieves, but does not remove, the first element of the queue.
@return the first element of the queue.
@throws NoSuchElementException if the queue is empty.
*/
    public Task peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.peek();
    }
/**

Retrieves and removes the first element of the queue.
@return the first element of the queue.
@throws NoSuchElementException if the queue is empty.
*/
    public Task remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.remove();

    }

//compilation error version lol
//public boolean remove(){
//     if (isEmpty()) {
//        throw new NoSuchElementException("Queue is empty");
//    }
//     return queue.remove(queue.peek());
//     
//}

   
}
