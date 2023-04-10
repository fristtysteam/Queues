
import java.time.LocalDate;
import java.util.Objects;

   /**

This class represents a task that has an owner, a description and a deadline.

The owner is the person assigned to complete the task.

The description is a brief summary of the task.

The deadline is the date by which the task must be completed.
*/
public class Task implements Comparable<Task>{

    protected String owner;
    protected String description;
    protected LocalDate deadline;

 
    /**

Constructs a new Task object with the specified owner, description, and deadline.
If the deadline is before or equal to the current date, an IllegalArgumentException is thrown.
@param owner the person assigned to complete the task.
@param description a brief summary of the task.
@param deadline the date by which the task must be completed.
@throws IllegalArgumentException if the deadline is before or equal to the current date.
*/
    public Task(String owner, String description, LocalDate deadline) {
        LocalDate currentDate = LocalDate.now();
        if (deadline.compareTo(currentDate) <= 0) {
            throw new IllegalArgumentException("L1");
        }
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
    }
    /**

Constructs a new Task object with default values for owner, description and deadline.
This constructor is used for testing purposes.
*/

    public Task() {
    }
/**

Returns the owner of the task.
@return the owner of the task.
*/
    public String getOwner() {
        return owner;
    }
/**

Returns the description of the task.
@return the description of the task.
*/
    public String getDescription() {
        return description;
    }
/**

Returns the deadline of the task.
@return the deadline of the task.
*/
    public LocalDate getDeadline() {
        return deadline;
    }
/**

Sets the owner of the task.
@param owner the new owner of the task.
*/ 
    public void setOwner(String owner) {
        this.owner = owner;
    }
/**
     * Sets the description of the task.
     * 
     * @param description the new description of the task
     */
    public void setDescription(String description) {
        this.description = description;
    }
/**
     * Sets the deadline of the task.
     * 
     * @param deadline the new deadline of the task
     * @throws IllegalArgumentException if the deadline is before or equal to the current date
     */
    public void setDeadline(LocalDate deadline) {
        LocalDate currentDate = LocalDate.now();
        if (deadline.compareTo(currentDate) <= 0) {
            throw new IllegalArgumentException("Deadline cannot be before or equal to the current date");
        }
        this.deadline = deadline;
    }
/**
     * Returns a hash code value for the task.
     * 
     * @return a hash code value for the task
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.owner);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.deadline);
        return hash;
    }
/**

Compares this Task to the specified object for equality based on their owner, description and deadline.
@param obj the object to compare with
@return true if the specified object is equal to this Task, false otherwise
*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;

        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.deadline, other.deadline);
    }
/**

Returns a string representation of this Task in the format "Task{owner=xxx, description=xxx}".
@return a string representation of this Task
*/
    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + '}';
    }
    /**

Compares this Task to the specified Task based on their deadlines.
@param other the other Task to compare with
@return a negative integer, zero, or a positive integer as this Task is less than, equal to, or greater than the specified Task.
*/
    @Override
    public int compareTo(Task other) {
        return deadline.compareTo(other.getDeadline());
    }

}
