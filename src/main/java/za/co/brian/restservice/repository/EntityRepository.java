package za.co.brian.restservice.repository;

import za.co.brian.restservice.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Long> {
}
