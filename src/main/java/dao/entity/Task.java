package dao.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @Column(name = "user_id")
    private long ownerId;

    @Column(name = "task_description")
    private String taskDescription;

    public Task(String taskDescription, long ownerId) {
        this.ownerId = ownerId;
        this.taskDescription = taskDescription;
    }

    public Task() {

    }
}
