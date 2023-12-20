package adapters;

import domain.VetRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.util.UUID;

public class CassandraVetRepository  implements VetRepository {

    private final CassandraOperations cassandraTemplate;

    public CassandraVetRepository(
        CassandraTemplate cassandraTemplate
    ) {
        this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public void add(domain.Vet vet) {
       cassandraTemplate.insert(toEntity(vet));
    }

    private static Vet toEntity(domain.Vet vet) {
        return new Vet(UUID.randomUUID().toString(), vet.name(), vet.surname(), vet.specialties().stream().toList());
    }
}
