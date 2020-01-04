package net.frolov.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "user_id")
    private Long ownerId;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "created")
    private ZonedDateTime created;

    public Task(String taskDescription, Long ownerId) {
        this.ownerId = ownerId;
        this.taskDescription = taskDescription;
        this.created = ZonedDateTime.now();
    }

    public Task() {
    }
}
