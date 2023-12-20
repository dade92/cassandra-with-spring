package adapters;

import domain.VetRepository;
import org.springframework.data.cassandra.core.cql.CqlTemplate;

import java.util.UUID;

public class CassandraVetRepository  implements VetRepository {

    private final CqlTemplate cqlTemplate;

    public CassandraVetRepository(
        CqlTemplate cqlTemplate
    ) {
        this.cqlTemplate = cqlTemplate;
    }

    @Override
    public void add(domain.Vet vet) {
       cqlTemplate.execute("");
    }

    private static Vet toEntity(domain.Vet vet) {
        return new Vet(UUID.randomUUID().toString(), vet.name(), vet.surname(), vet.specialties().stream().toList());
    }
}
