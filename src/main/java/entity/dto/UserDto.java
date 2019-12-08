package entity.dto;

import entity.Task;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private long id;

    private String description;

    private Set<Task> tasks;
}
