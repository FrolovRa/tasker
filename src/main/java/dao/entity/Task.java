package dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    private long id;

    private long owner_id;
}
