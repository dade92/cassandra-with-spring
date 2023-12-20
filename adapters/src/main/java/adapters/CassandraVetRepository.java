package adapters;

import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Statement;
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
        PreparedStatement preparedStatement = cqlTemplate.getSession().prepare("insert into vet (id, name, surname) values (?, ?, ?)");
        Statement insertStatement = preparedStatement.bind(UUID.randomUUID().toString(), vet.name(), vet.surname());
       cqlTemplate.execute(insertStatement);
    }

    private Vet toEntity(domain.Vet vet) {
        return new Vet(UUID.randomUUID().toString(), vet.name(), vet.surname(), vet.specialties().stream().toList());
    }
}
