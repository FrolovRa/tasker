package net.frolov.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class entityClass, long id) {
        super(String.format("%s entity with id=%s is not found.", entityClass.getSimpleName(), id));
    }
}
