package za.co.brian.restservice.controller;

import za.co.brian.restservice.model.Entity;
import za.co.brian.restservice.model.Cic;
import za.co.brian.restservice.service.EntityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cic")
public class EntityController {

    private EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    // Return a list of entities
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Entity> getAllEntities() {
        return entityService.getAllEntities();
    }

    // Return a specific entity
    @GetMapping(
            path = ("/{entityId}"),
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Entity getEntity(@PathVariable("entityId") Long entityId) throws NotFoundException {
        return entityService.getEntity(entityId);
    }

    // Create a new entity
    @PostMapping(
            path = ("/entity"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEntity(@RequestBody Entity entity) {
        entityService.addEntity(entity);
    }

    // Create a Cic to the entity
    @PostMapping(
            path = ("/{entityId}/cic"),
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCic(
            @PathVariable("entityId") Long entityId,
            @RequestBody Cic cic) throws NotFoundException {
        entityService.addCic(entityId, cic);
    }

    // Update entity
    @PutMapping(
            path = ("/{entityId}"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEntity(
            @PathVariable("entityId") Long entityId,
            @RequestBody Entity entity) throws NotFoundException {
        entityService.updateEntity(entityId, entity);
    }

    // Update cic of the entity
    @PutMapping(
            path = ("/{entityId}/cic/{cicId}"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCic(
            @PathVariable("entityId") Long entityId,
            @PathVariable("cicId") Long cicId,
            @RequestBody Cic cic) throws NotFoundException {
        entityService.updateCic(entityId, cicId, cic);
    }

    // Remove entity
    @DeleteMapping(
            path = "/{entityId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEntity(@PathVariable("entityId") Long entityId) throws NotFoundException {
        entityService.deleteEntity(entityId);
    }

    // Remove entity cic
    @DeleteMapping(
            path = "/{entityId}/cic/{cicId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCic(
            @PathVariable("entityId") Long entityId,
            @PathVariable("cicId") Long cicId) throws NotFoundException {
        entityService.deleteCic(entityId, cicId);
    }
}
