package webapp;

import adapters.CassandraVetRepository;
import domain.AddVetUseCase;
import domain.VetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;

@Configuration
public class VetConfiguration {

    @Bean
    public AddVetUseCase addVetUseCase(VetRepository vetRepository) {
        return new AddVetUseCase(vetRepository);
    }

    @Bean
    public VetRepository vetRepository(CassandraTemplate cassandraTemplate) {
        return new CassandraVetRepository(cassandraTemplate);
    }


}
