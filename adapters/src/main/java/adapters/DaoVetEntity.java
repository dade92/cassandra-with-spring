package adapters;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DaoVetEntity extends CrudRepository<VetRecord, UUID> {
    VetRecord findByFirstName(String username);
}
