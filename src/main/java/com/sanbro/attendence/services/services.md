# Service Layer Documentation

## Overview

The service layer in this Spring Boot application is responsible for managing the business logic related to entities. Given the straightforward nature of this application, the primary responsibilities of the service layer include:

- Managing `createdAt` and `updatedAt` timestamps for each entity.
- Providing methods for CRUD (Create, Read, Update, Delete) operations.

## Responsibilities

### Timestamp Management

The service layer handles the automatic updating of `createdAt` and `updatedAt` fields for each entity. This ensures that every entity maintains accurate creation and modification timestamps.

### CRUD Operations

The service layer provides the following CRUD operations for each entity:

- **Create:** Adds a new entity to the system.
- **Read:** Retrieves entity information based on provided identifiers.
- **Update:** Modifies existing entity details.
- **Delete:** Removes an entity from the system.

## Example Service Class

Here is a basic example of a service class that implements the above responsibilities:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    // Create
    public Entity createEntity(Entity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return entityRepository.save(entity);
    }

    // Read
    public Entity getEntityById(Long id) {
        return entityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    // Update
    public Entity updateEntity(Long id, Entity updatedEntity) {
        Entity existingEntity = getEntityById(id);
        existingEntity.setUpdatedAt(LocalDateTime.now());
        existingEntity.setSomeField(updatedEntity.getSomeField());
        // Set other fields as needed
        return entityRepository.save(existingEntity);
    }

    // Delete
    public void deleteEntity(Long id) {
        if (!entityRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found");
        }
        entityRepository.deleteById(id);
    }
}
