package dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    private long id;

    private String description;
    @OneToMany(mappedBy = "user_id")
    private Set<Task> tasks;
}
