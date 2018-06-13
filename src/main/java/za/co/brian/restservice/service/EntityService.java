package za.co.brian.restservice.service;

import za.co.brian.restservice.model.Entity;
import za.co.brian.restservice.model.Cic;
import za.co.brian.restservice.repository.EntityRepository;
import za.co.brian.restservice.repository.CicRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntityService {

    private EntityRepository entityRepository;
    private CicRepository cicRepository;

    @Autowired
    public EntityService(EntityRepository entityRepository, CicRepository cicRepository) {
        this.entityRepository = entityRepository;
        this.cicRepository = cicRepository;
    }

    // Return a list of entities
    public List<Entity> getAllEntities() {
        return this.entityRepository.findAll();
    }

    // Return a specific entity
    public Entity getEntity(Long entityId) throws NotFoundException {
        Long id = validateEntity(entityId);
        return entityRepository.findOne(id);
    }

    // Create a new entity
    public void addEntity(Entity entity) {
        this.entityRepository.save(entity);
    }

    // Create a cic to the entity
    public void addCic(Long entityId, Cic cic) throws NotFoundException {
        Entity entity = getEntity(entityId);
        cic.setEntity(entity);
        this.cicRepository.save(cic);
    }

    // Update entity
    public void updateEntity(Long entityId, Entity entity) throws NotFoundException {
        Long id = validateEntity(entityId);
        entity.setId(id);
        entityRepository.save(entity);
    }

    // Update cic of the entity
    public void updateCic(Long entityId, Long cicId, Cic cic) throws NotFoundException {
        if (doesCicBelongToEntity(entityId, cicId)) {
            cic.setCicId(cicId);
            cicRepository.save(cic);
        }
    }

    // Remove entity
    public void deleteEntity(Long entityId) throws NotFoundException {
        Long id = validateEntity(entityId);
        entityRepository.delete(id);
    }

    // Remove entity Cic
    public void deleteCic(Long entityId, Long cicId) throws NotFoundException {
        if (doesCicBelongToEntity(entityId, cicId))
            cicRepository.delete(cicId);
    }


    // Check if specific cic belongs to specific entity
    private boolean doesCicBelongToEntity(Long entityId, Long cicId) throws NotFoundException {
        this.validateEntity(entityId);

        Cic cic = cicRepository.findOne(cicId);

        if (Objects.equals(entityId, cic.getEntity().getId())) {
            return true;
        } else {
            throw new NotFoundException
                    ("Entity with ID: '" + entityId + "' does not contain cic with ID: '" + cic.getCicId() + "'");
        }

    }

    // Check if specific entity exists in the database
    private Long validateEntity(Long entityId) throws NotFoundException {
        return Optional.ofNullable(entityRepository.findOne(entityId))
                .map(Entity::getId)
                .orElseThrow(() -> new NotFoundException
                        ("Entity with ID: '" + entityId + "' not found"));
    }

}
