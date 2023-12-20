package adapters;

import domain.VetRepository;
import org.springframework.data.cassandra.core.CassandraOperations;

import java.util.UUID;

public class CassandraVetRepository  implements VetRepository {

    private final CassandraOperations cassandraOperations;

    public CassandraVetRepository(
        CassandraOperations cassandraOperations
    ) {
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public void add(domain.Vet vet) {
       cassandraOperations.insert(toEntity(vet));
    }

    private static Vet toEntity(domain.Vet vet) {
        return new Vet(UUID.randomUUID().toString(), vet.name(), vet.surname(), vet.specialties().stream().toList());
    }
}
