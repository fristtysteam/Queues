import java.time.LocalDate;
import java.util.Objects;

//
//1. A constructor that takes in the three parameters – owner, description and deadline. You should perform
//validation to confirm that the deadline field is not before or equal to the current date, and handle any failing
//appropriately.
//Note: You can use the compareTo method from the LocalDate class to check this (today’s date can be gotten using
//LocalDate.now()).
//2. Getter and setter methods for the three fields. Again, you should validate the deadline information in
//setDeadline() and handle any failing values appropriately.
//3. An equals() method and a hashCode() method – these should base their calculation on the owner, description
//and deadline fields.
//4. A toString() method that returns the artist and title information in a well-formatted manner.
public class Task {

    protected String owner;
    protected String description;
    protected LocalDate deadline;

    public Task(String owner, String description, LocalDate deadline) {
        LocalDate currentDate = LocalDate.now();
        if (deadline.compareTo(currentDate) <= 0) {
            throw new IllegalArgumentException("Deadline cannot be before or equal to the current date");
        }
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
    }

    public Task() {
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        LocalDate currentDate = LocalDate.now();
        if (deadline.compareTo(currentDate) <= 0) {
            throw new IllegalArgumentException("Deadline cannot be before or equal to the current date");
        }
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.owner);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            throw new IllegalArgumentException("Both objects are the same?");
           
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

    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + '}';
    }

    

}
