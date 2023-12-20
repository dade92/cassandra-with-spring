package webapp;

import adapters.CassandraVetRepository;
import adapters.DaoVetEntity;
import domain.AddVetUseCase;
import domain.VetRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VetConfiguration {

    @Bean
    public AddVetUseCase addVetUseCase(VetRepository vetRepository) {
        return new AddVetUseCase(vetRepository);
    }

    @Bean
    public VetRepository vetRepository(DaoVetEntity daoVetEntity) {
        return new CassandraVetRepository(daoVetEntity);
    }


}
