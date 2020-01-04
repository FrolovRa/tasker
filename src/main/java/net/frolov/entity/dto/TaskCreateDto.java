package net.frolov.entity.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TaskCreateDto {
    private long ownerId;

    private String taskDescription;

    private ZonedDateTime created;
}
