package webapp;

import adapters.CassandraVetRepository;
import domain.AddVetUseCase;
import domain.VetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.CqlTemplate;

@Configuration
public class VetConfiguration {

    @Bean
    public AddVetUseCase addVetUseCase(VetRepository vetRepository) {
        return new AddVetUseCase(vetRepository);
    }

    @Bean
    public VetRepository vetRepository(CqlTemplate cqlTemplate) {
        return new CassandraVetRepository(cqlTemplate);
    }


}
