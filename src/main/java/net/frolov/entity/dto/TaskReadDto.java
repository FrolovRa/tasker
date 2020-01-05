package net.frolov.entity.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TaskReadDto implements Comparable<TaskReadDto> {
    private long id;

    private long ownerId;

    private String taskDescription;

    private ZonedDateTime created;

    @Override
    public int compareTo(TaskReadDto anotherTaskReadDto) {
        final int createdDiff = this.created.compareTo(anotherTaskReadDto.getCreated());
        if (createdDiff != 0) return createdDiff;
        return ((int) (this.id - anotherTaskReadDto.getId()));
    }
}
