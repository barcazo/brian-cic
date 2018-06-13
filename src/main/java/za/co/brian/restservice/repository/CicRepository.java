package za.co.brian.restservice.repository;

import za.co.brian.restservice.model.Cic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CicRepository extends JpaRepository<Cic, Long> {
}
