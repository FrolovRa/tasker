package net.frolov.entity.dto;

import net.frolov.entity.Task;
import lombok.Data;

import java.util.Set;

@Data
public class UserReadDto {
    private long id;

    private String description;

    private Set<Task> tasks;
}
