package webapp;

import adapters.CassandraVetRepository;
import domain.AddVetUseCase;
import domain.VetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;

@Configuration
public class VetConfiguration {

    @Bean
    public AddVetUseCase addVetUseCase(VetRepository vetRepository) {
        return new AddVetUseCase(vetRepository);
    }

    @Bean
    public VetRepository vetRepository(CassandraOperations cassandraTemplate) {
        return new CassandraVetRepository(cassandraTemplate);
    }


}
