package net.frolov.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerId")
    @OrderBy("created ASC")
    private Set<Task> tasks;
}