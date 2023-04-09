import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Queue;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Frist
 */
public class BoundedPriorityQueueSet extends Task{
    
//    implement a BoundedPriorityQueueSet to hold Task objects. This queue should be implemented as a link-based queue
//class named BoundedPriorityQueueSet. The following functionality should be provided:
//1. A default constructor that sets the maximum size of the queue to be 10 Tasks.
//2. A parameterised constructor that takes in one parameter – the maximum size of the queue.
//3. A method called size() that takes no parameters & returns the number of Tasks currently stored in your queue.
//4. A method called isEmpty() that takes no parameters. This should return whether there is data currently stored
//in the queue.
    
    protected int maxSize ;
protected Queue<Task> queue;

    public BoundedPriorityQueueSet(int maxSize, Queue<Task> queue, String owner, String description, LocalDate deadline) {
        super(owner, description, deadline);
        this.maxSize = 10;
        this.queue = queue;
    }

    public BoundedPriorityQueueSet() {
        this.maxSize = 10;
    }
    
     public int size() {
        return queue.size();
    }

     public boolean isEmpty(){
         if(queue.size() > 0){
             return true;
         }
         else{
             return false;
         }
     }
     public void isEmptyV2(){
         if(!queue.isEmpty()){
             System.out.println("queue is not empty");;
         }
         else{
             System.out.println("queue is empty");
         }
     }
     public boolean isEmptyV3(){
        return queue.isEmpty();
     }
     
     
//     5. A method called isFull() that takes no parameters. This should return whether the queue is currently full.



     
    public boolean isFull() {
        return queue.size() >= maxSize;
    }
    public boolean isFullV2() {
        if(queue.size() >= maxSize){
            return true;
        }
        else{
            
            return false;
        }
    }
    public void clearIfFull(){
        if(isFull() == true){
            queue.clear();
           
        }
        System.out.println("queue is now clear");
    }
    //6. A method called add() that takes a single parameter, a Task to be added to the queue. As this is a priority
//queue, you should add the Task into the appropriate position based on its priority relative to what is already in
//the queue. Where the queue is full when this method is called, an IllegalStateException should be
//thrown. Where the Task is already present in the queue, a DuplicateElementException should be thrown.
//The method should return the position at which the Task was added.
    
    
   public int add(Task task) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }

        if (queue.contains(task)) {
            throw new DuplicateElementException("Task already exists in queue.");
        }
boolean isAdded = queue.offer(task);

if(!isAdded){
    throw new IllegalStateException("failed to add to the queue");
}
return queue.size() - 1;
    }


//7. A method called peek() that takes no parameters. The method should return the first Task in the queue. Where
//the queue is empty when this method is called, a NoSuchElementException should be thrown.

public Task peek() {
    if (isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
    }
    return queue.peek();
}


//8. A method called remove() that takes no parameters. The method should remove the first Task from the queue
//and return it. Where the queue is empty when this method is called, a NoSuchElementException should be
//thrown.

public Task remove(){
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


    
    
    
   

